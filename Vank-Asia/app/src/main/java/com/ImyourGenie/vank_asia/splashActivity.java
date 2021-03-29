package com.ImyourGenie.vank_asia;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class splashActivity extends AppCompatActivity {
    AnimationDrawable animDrawable;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        //전체화면만들기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splashActivity.this, MainActivity.class));
                finish();
            }
        }, 1800);
    }
}
