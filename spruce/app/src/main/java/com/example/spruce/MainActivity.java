package com.example.spruce;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private BackPressCloseHandler backPressCloseHandler;
    TextView textView;

    @Override
    public void onBackPressed() { //'뒤로' 두번누르면 종료
        backPressCloseHandler.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backPressCloseHandler = new BackPressCloseHandler(this);

        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.testyong);
        Intent intent = getIntent();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_start = new Intent(MainActivity.this, spruceActivity.class);
                startActivity(intent_start);
                Toast.makeText(getApplicationContext(), "화면 이동", Toast.LENGTH_LONG).show();
            }});
    }
}