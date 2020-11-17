package com.ImyourGenie.vank_asia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class Frag1 extends Fragment// Fragment 클래스를 상속받아야한다
{
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1,container,false);

        ImageView iv = (ImageView) view.findViewById(R.id.gifImage);
        Glide.with(this).load(R.raw.asia).into(iv);

        return view;
    }
}
