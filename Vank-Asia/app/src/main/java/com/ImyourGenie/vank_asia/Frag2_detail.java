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

public class Frag2_detail extends Activity {

    String korea_name = ((Frag2) Frag2.context).korea_name;

    String str1 = "인도네시아";
    String str2 = "태국";
    String str3 = "필리핀";
    String str4 = "말레이시아";
    String str5 = "싱가포르";
    String str6 = "브루나이";
    String str7 = "베트남";
    String str8 = "라오스";
    String str9 = "미얀마";
    String str10 = "캄보디아";


    // 링크걸기참고 https://hongku.tistory.com/205

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(str6.equals(korea_name)){ //브루나이 준비안됨
            toastshow("준비중입니다. 조금만 기다려주세요 ^^;");
            onBackPressed();
        }

        else{
            toastshow(korea_name + "을(를) 소개합니다!");
            if(str1.equals(korea_name)){ //인도네시아
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221789982674"));
                startActivity(intent);onBackPressed();
            }
            else if(str2.equals(korea_name)){ //태국
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221833980919"));
                startActivity(intent);onBackPressed();
            }
            else if(str3.equals(korea_name)){ //필리핀
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221826039646"));
                startActivity(intent);onBackPressed();
            }
            else if(str4.equals(korea_name)){ //말레이시아
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221804650834"));
                startActivity(intent);onBackPressed();
            }
            else if(str5.equals(korea_name)){ //싱가포르
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221836785857"));
                startActivity(intent);onBackPressed();
            }
            else if(str7.equals(korea_name)){ //베트남
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221514963379"));
                startActivity(intent);onBackPressed();
            }
            else if(str8.equals(korea_name)){ //라오스
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221971813662"));
                startActivity(intent);onBackPressed();
            }
            else if(str9.equals(korea_name)){ //미얀마
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221520570343"));
                startActivity(intent);onBackPressed();
            }
            else if(str10.equals(korea_name)){ //캄보디아
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999/221804682127"));
                startActivity(intent);onBackPressed();
            }
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
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show(); }
}
