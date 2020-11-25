package com.ImyourGenie.vank_asia;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.HashMap;

public class Frag3 extends Fragment {
    private View view;

    Button buttontouch_1;
    Button buttontouch_2;


    ImageView imageView1;
    ImageView imageView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3,container,false);



        buttontouch_1 = (Button) view.findViewById(R.id.buttontouch_1);
        buttontouch_2 = (Button) view.findViewById(R.id.buttontouch_2);


        // 클릭 손가락 깜빡깜빡
        imageView1 = (ImageView) view.findViewById(R.id.imagetouch_1); //손가락
        imageView2 = (ImageView) view.findViewById(R.id.imagetouch_2); //손가락
        Animation startAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.blink_animation);
        imageView1.startAnimation(startAnimation);
        imageView2.startAnimation(startAnimation);


        //이미지 누르면 설명창으로
        buttontouch_1.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Frag3.super.getContext(), vank_detail.class);
                toastshow(v,"반크를 소개합니다!");
                startActivity(intent);
            }
        });

        buttontouch_2.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Frag3.super.getContext(), we_detail.class);
                toastshow(v,"아시아친선대사를 소개합니다!");
                startActivity(intent);

            }
        });



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
        toast.setGravity(Gravity.BOTTOM,0,100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show(); }
}