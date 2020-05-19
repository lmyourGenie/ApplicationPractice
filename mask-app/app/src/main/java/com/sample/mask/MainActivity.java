package com.sample.mask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements NaverMap.OnMapClickListener, Overlay.OnClickListener, OnMapReadyCallback, NaverMap.OnCameraChangeListener, NaverMap.OnCameraIdleListener {
    private static final int ACCESS_LOCATION_PERMISSION_REQUEST_CODE = 100;

    private FusedLocationSource locationSource;
    private NaverMap naverMap;
    private InfoWindow infoWindow;
    private List<Marker> markerList = new ArrayList<Marker>();
    private boolean isCameraAnimated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);  //지도데이터를 불러옴 , onMapReady callback 호출
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_list:
                Intent intent = new Intent(this, StoreActivity.class);
                LatLng mapCenter = naverMap.getCameraPosition().target;
                intent.putExtra("longitude", mapCenter.longitude);
                intent.putExtra("latitude", mapCenter.latitude);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {  //지도 화면을 현재 위치로 이동시킴
        this.naverMap = naverMap;

        locationSource = new FusedLocationSource(this, ACCESS_LOCATION_PERMISSION_REQUEST_CODE);
        naverMap.setLocationSource(locationSource);
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(true);

        naverMap.addOnCameraChangeListener(this);
        naverMap.addOnCameraIdleListener(this);
        naverMap.setOnMapClickListener(this);

        LatLng mapCenter = naverMap.getCameraPosition().target;  //중심점의 위치 (위도 경도)를 파악
        fetchStoreSale(mapCenter.latitude, mapCenter.longitude, 5000); //반경 5000m이내의 판매처를 조회

        infoWindow = new InfoWindow();
        infoWindow.setAdapter(new InfoWindow.DefaultViewAdapter(this) {
            @NonNull
            @Override
            protected View getContentView(@NonNull InfoWindow infoWindow) {  //인포윈도우에 띄울 내용 작성
                Marker marker = infoWindow.getMarker();
                Store store = (Store) marker.getTag();
                View view = View.inflate(MainActivity.this, R.layout.view_info_window, null);
                ((TextView) view.findViewById(R.id.name)).setText(store.name);
                if ("plenty".equalsIgnoreCase(store.remain_stat)) {
                    ((TextView) view.findViewById(R.id.stock)).setText("100개 이상");
                } else if ("some".equalsIgnoreCase(store.remain_stat)) {
                    ((TextView) view.findViewById(R.id.stock)).setText("30개 이상 100개 미만");
                } else if ("few".equalsIgnoreCase(store.remain_stat)) {
                    ((TextView) view.findViewById(R.id.stock)).setText("2개 이상 30개 미만");
                } else if ("empty".equalsIgnoreCase(store.remain_stat)) {
                    ((TextView) view.findViewById(R.id.stock)).setText("1개 이하");
                } else if ("break".equalsIgnoreCase(store.remain_stat)) {
                    ((TextView) view.findViewById(R.id.stock)).setText("판매중지");
                } else {
                    ((TextView) view.findViewById(R.id.stock)).setText(null);
                }
                ((TextView) view.findViewById(R.id.time)).setText("입고 " + store.stock_at);
                return view;
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case ACCESS_LOCATION_PERMISSION_REQUEST_CODE:  //권한 허용되었을 때
                locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults);  //현재위치에 접근
                return;
        }
    }

    @Override
    public void onCameraChange(int reason, boolean animated) {
        isCameraAnimated = animated;
    }  //카메라가 이동되고 있는지 확인하고

    @Override
    public void onCameraIdle() {   //카메라가 멈췄을 때(=지도 고정)의 포지션을 받아서 다시 반경 5000m의 storesales정보를 업데이트
        if (isCameraAnimated) {
            LatLng mapCenter = naverMap.getCameraPosition().target;
            fetchStoreSale(mapCenter.latitude, mapCenter.longitude, 5000);
        }
    }

    private void fetchStoreSale(double lat, double lng, int m) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://8oi9s0nnth.apigw.ntruss.com").addConverterFactory(GsonConverterFactory.create()).build();
        //api를 제공하는 도메인과 , 전달된 json형태 데이터를 java로 변환
        MaskApi maskApi = retrofit.create(MaskApi.class);
        maskApi.getStoresByGeo(lat, lng, m).enqueue(new Callback<StoreSaleResult>() {
            @Override
            public void onResponse(Call<StoreSaleResult> call, Response<StoreSaleResult> response) {  //호출 성공시
                if (response.code() == 200) {  //200은 통상 http의 '정상적인 프로세스 완료'를 뜻함
                    StoreSaleResult result = response.body();
                    updateMapMarkers(result);
                }
            }

            @Override
            public void onFailure(Call<StoreSaleResult> call, Throwable t) {  //호출 실패시

            }
        });
    }

    private void updateMapMarkers(StoreSaleResult result) {  //마커생성
        resetMarkerList();
        if (result.stores != null && result.stores.size() > 0) {    //판매처가 하나 이상 반환되면 루프를 돔
            for (Store store : result.stores) {
                Marker marker = new Marker();
                marker.setTag(store);
                marker.setPosition(new LatLng(store.lat, store.lng));
                if ("plenty".equalsIgnoreCase(store.remain_stat)) {    //재고 현황에 따라 다른 아이콘
                    marker.setIcon(OverlayImage.fromResource(R.drawable.marker_green));
                } else if ("some".equalsIgnoreCase(store.remain_stat)) {
                    marker.setIcon(OverlayImage.fromResource(R.drawable.marker_yellow));
                } else if ("fiew".equalsIgnoreCase(store.remain_stat)) {
                    marker.setIcon(OverlayImage.fromResource(R.drawable.marker_red));
                } else {
                    marker.setIcon(OverlayImage.fromResource(R.drawable.marker_gray));
                }
                marker.setAnchor(new PointF(0.5f, 1.0f));  //아이콘에서 x축으로 50%지점(중심) y축으로 100%지점(바닥)
                marker.setMap(naverMap);
                marker.setOnClickListener(this);
                markerList.add(marker);
            }
        }
    }

    @Override
    public void onMapClick(@NonNull PointF pointF, @NonNull LatLng latLng) {  //지도 빈 영역을 클릭했을 때
        if (infoWindow.getMarker() != null) {  //인포윈도우가 띄워져있다면
            infoWindow.close();  //닫음
        }
    }

    @Override
    public boolean onClick(@NonNull Overlay overlay) {  //마커를 클릭했을 때 동작
        if (overlay instanceof Marker) {
            Marker marker = (Marker) overlay;
            if (marker.getInfoWindow() != null) {  //이미 그 마커위에 인포윈도우가 띄워져있다면
                infoWindow.close();   //닫음
            } else {
                infoWindow.open(marker);  //인포윈도우 <- 말풍선처럼 생김
            }
            return true;
        }
        return false;
    }

    private void resetMarkerList() {
        if (markerList != null && markerList.size() > 0) {
            for (Marker marker : markerList) {
                marker.setMap(null);
            }
            markerList.clear();
        }
    }
}
