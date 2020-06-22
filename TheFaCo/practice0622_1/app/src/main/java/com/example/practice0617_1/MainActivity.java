package com.example.practice0617_1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practice0617_1.R;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    ListView Bus_List;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ActionBar ab = getSupportActionBar() ;

        ab.setIcon(R.drawable.icon_pink);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        왜 아이콘이랑 글자랑 동시에 표현이 안되는거야ㅠ-ㅠ
        */

        // 권한 요청
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET}, 1000);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //우측상단 메뉴가 보이도록 설정
        getMenuInflater().inflate(R.menu.menu_bottom, menu) ;

        return true ;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.navigation_menu1:
                return true;
            case R.id.navigation_menu2: //TheFaCo란?
                Intent descript_Intent = new Intent(this, app_Description.class);
                startActivity(descript_Intent);
                return true;
            case R.id.navigation_menu3:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}