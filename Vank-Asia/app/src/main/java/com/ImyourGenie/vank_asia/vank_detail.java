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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class vank_detail extends Activity {
    Button button_blog;
    Button button_youtube;
    Button button_vank;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_vank);


        button_vank = (Button) findViewById(R.id.button_vank);
        button_youtube = (Button) findViewById(R.id.button_youtube);
        button_blog = (Button) findViewById(R.id.button_blog);


        button_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/prkorea"));
                startActivity(intent);
                toastshow("반크 공식유튜브 선택");
                onBackPressed();
            }
        });

        button_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/vank1999"));
                startActivity(intent);
                toastshow("반크 공식블로그 선택");
                onBackPressed();
            }
        });

        button_vank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://prkorea.com/"));
                startActivity(intent);
                toastshow("반크 공식사이트 선택");
                onBackPressed();
            }
        });

    }

    public void toastshow(String string) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.toast_layout, (ViewGroup) this.findViewById(R.id.toast_layout));
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
