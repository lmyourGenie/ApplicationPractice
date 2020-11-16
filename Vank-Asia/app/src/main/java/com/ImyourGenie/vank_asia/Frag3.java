package com.ImyourGenie.vank_asia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.HashMap;

public class Frag3 extends Fragment {
    private View view;

    ImageView imageView;
    ImageView imageView2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3,container,false);



        imageView = (ImageView) view.findViewById(R.id.image_vank);
        imageView2 = (ImageView) view.findViewById(R.id.image_we);


        imageView.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Frag3.super.getContext(), vank_detail.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Frag3.super.getContext(), we_detail.class);
                startActivity(intent);
            }
        });

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
