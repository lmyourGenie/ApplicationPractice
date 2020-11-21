package com.ImyourGenie.vank_asia;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.HashMap;

public class Frag3 extends Fragment {
    private View view;

    Button button1;
    Button button2;

    ImageView imageView1;
    ImageView imageView2;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3,container,false);


        button1 = (Button) view.findViewById(R.id.buttontouch_1);
        button2 = (Button) view.findViewById(R.id.buttontouch_2);


        imageView1 = (ImageView) view.findViewById(R.id.imagetouch_1); //손가락
        imageView2 = (ImageView) view.findViewById(R.id.imagetouch_2); //손가락
        Animation startAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.blink_animation);
        imageView1.startAnimation(startAnimation);
        imageView2.startAnimation(startAnimation);

        button1.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Frag3.super.getContext(), vank_detail.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Frag3.super.getContext(), we_detail.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
