package com.ImyourGenie.vank_asia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class Frag2 extends Fragment implements TextWatcher{
    private View view;

    public String korea_name;
    public String english_name;

    public static Frag2 context;

    ListView list_new;
    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> data_hashmap;
    EditText searchBox;
    ImageView icon_search;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2, container, false);

        searchBox = (EditText) view.findViewById(R.id.searchbox1);  //검색창
        list_new = view.findViewById(R.id.list_new1);  //아세안 회원국 데이터
        icon_search = (ImageView) view.findViewById(R.id.icon_search);  //돋보기 아이콘

        data = new ArrayList<HashMap<String, String>>();

        //아세안 10개국//
        data_hashmap = new HashMap<String, String>();
        data_hashmap.put("국가명", "인도네시아");
        data_hashmap.put("영어", "Indonesia");
        data.add(data_hashmap);

        data_hashmap = new HashMap<String, String>();
        data_hashmap.put("국가명", "태국");
        data_hashmap.put("영어", "Thailand");
        data.add(data_hashmap);

        data_hashmap = new HashMap<String, String>();
        data_hashmap.put("국가명", "필리핀");
        data_hashmap.put("영어", "Philippines");
        data.add(data_hashmap);

        data_hashmap = new HashMap<String, String>();
        data_hashmap.put("국가명", "말레이시아");
        data_hashmap.put("영어", "Malaysia");
        data.add(data_hashmap);

        data_hashmap = new HashMap<String, String>();
        data_hashmap.put("국가명", "싱가포르");
        data_hashmap.put("영어", "Singapore");
        data.add(data_hashmap);

        data_hashmap = new HashMap<String, String>();
        data_hashmap.put("국가명", "브루나이");
        data_hashmap.put("영어", "Brunei");
        data.add(data_hashmap);

        data_hashmap = new HashMap<String, String>();
        data_hashmap.put("국가명", "베트남");
        data_hashmap.put("영어", "Vietnam");
        data.add(data_hashmap);

        data_hashmap = new HashMap<String, String>();
        data_hashmap.put("국가명", "라오스");
        data_hashmap.put("영어", "Laos");
        data.add(data_hashmap);

        data_hashmap = new HashMap<String, String>();
        data_hashmap.put("국가명", "미얀마");
        data_hashmap.put("영어", "Myanmar");
        data.add(data_hashmap);

        data_hashmap = new HashMap<String, String>();
        data_hashmap.put("국가명", "캄보디아");
       data_hashmap.put("영어", "Cambodia");
        data.add(data_hashmap);


        SimpleAdapter adapter = new SimpleAdapter(
                getContext(), data,
                android.R.layout.simple_list_item_2,
                new String[]{"국가명", "영어"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );
        list_new.setAdapter(adapter);


        list_new.setTextFilterEnabled(true);
        searchBox.addTextChangedListener((TextWatcher) this);

        //돋보기 클릭 시 -> 리스트 띄우고 -> 리스트 누르면 지도 띄우기
        icon_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_new.setVisibility(View.VISIBLE);
                toastshow(v, "검색 결과");
            }
        });

        list_new.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> map = (HashMap<String, String>) list_new.getItemAtPosition(position);
                korea_name = map.get("국가명");
                english_name = map.get("영어");

                Intent intent = new Intent(Frag2.super.getContext(), Frag2_detail.class);
                startActivity(intent);
            }
        });
        context = this;

        return view;
    }


    public void toastshow(View view, String string) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.toast_layout, (ViewGroup) getView().findViewById(R.id.toast_layout));
        TextView text = layout.findViewById(R.id.text);
        Toast toast = new Toast(getContext());
        text.setText(string);
        text.setTextSize(15);
        text.setTextColor(Color.WHITE);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show(); }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        list_new.setVisibility(View.VISIBLE);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        list_new.setVisibility(View.VISIBLE);
        list_new.setFilterText(searchBox.getText().toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (searchBox.getText().length() == 0) {
            list_new.clearTextFilter();
        }
    }
}
