package com.example.practice0617_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

public class SplashActivity extends Activity {
    AnimationDrawable animDrawable;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_splash);
        LinearLayout view = (LinearLayout) findViewById(R.id.viewcontainer);


        animDrawable = (AnimationDrawable) (view.getBackground() != null && view.getBackground() instanceof AnimationDrawable ?
                view.getBackground() : null);
        if (animDrawable != null) {
            animDrawable.setEnterFadeDuration(700);
            animDrawable.setExitFadeDuration(700);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 2100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animDrawable != null && !animDrawable.isRunning()) {
            animDrawable.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animDrawable != null && animDrawable.isRunning()) {
            animDrawable.stop();
        }
    }
}

