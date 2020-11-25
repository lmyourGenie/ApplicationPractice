package com.ImyourGenie.vank_asia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Frag2_detail_detail extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String secondIntent = getIntent().getStringExtra("국가명");
        toastshow(secondIntent + "에 대한 카드뉴스를 보여드릴게요 '3'♥");

        if(secondIntent.equals("인도네시아")){ //인도네시아
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221789982674"));
            startActivity(intent);onBackPressed();
        }
        else if(secondIntent.equals("태국")){ //태국
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221833980919"));
            startActivity(intent);onBackPressed();
        }
        else if(secondIntent.equals("필리핀")){ //필리핀
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221826039646"));
            startActivity(intent);onBackPressed();
        }
        else if(secondIntent.equals("말레이시아")){ //말레이시아
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221804650834"));
            startActivity(intent);onBackPressed();
        }
        else if(secondIntent.equals("싱가포르")){ //싱가포르
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221836785857"));
            startActivity(intent);onBackPressed();
        }
        else if(secondIntent.equals("베트남")){ //베트남
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221514963379"));
            startActivity(intent);onBackPressed();
        }
        else if(secondIntent.equals("라오스")){ //라오스
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221971813662"));
            startActivity(intent);onBackPressed();
        }
        else if(secondIntent.equals("미얀마")){ //미얀마
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221520570343"));
            startActivity(intent);onBackPressed();
        }
        else if(secondIntent.equals("캄보디아")){ //캄보디아
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221804682127"));
            startActivity(intent);onBackPressed();
        }

    }
    public void toastshow(String string) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout));
        TextView text = layout.findViewById(R.id.text);
        Toast toast = new Toast(getApplicationContext());
        text.setText(string);
        text.setTextSize(15);
        text.setTextColor(Color.WHITE);
        toast.setGravity(Gravity.BOTTOM,0,100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show(); }
}
