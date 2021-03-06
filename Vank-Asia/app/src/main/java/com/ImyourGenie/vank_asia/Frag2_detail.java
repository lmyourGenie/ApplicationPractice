package com.ImyourGenie.vank_asia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Frag2_detail extends AppCompatActivity {

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

    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;

    ImageView imageView_f;
    ImageView imageView;
    ImageView imageView_cardnews;

    // 링크걸기참고 https://hongku.tistory.com/205

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_country);
        Excel();
        ImageView iv = (ImageView)findViewById(R.id.imageView_cardnews);
        Glide.with(this).load(R.drawable.cardnews).into(iv);
    }
//https://m.blog.naver.com/PostView.nhn?blogId=gjdeveloper&logNo=220558182815&proxyReferer=https:%2F%2Fwww.google.com%2F
    private void Excel() {
        Workbook wb = null;
        Sheet sheet = null;

        try {
            InputStream is = getBaseContext().getResources().getAssets().open("my_excel.xls");
            wb = Workbook.getWorkbook(is);

            if (wb != null) {
                sheet = wb.getSheet(0);   // 시트 불러오기
                if (sheet != null) {

                    if (str1.equals(korea_name)) { //인도네시아

                        toastshow("인도네시아를 선택하셨습니다.");

                        int row = 0; //인도네시아
                        String contents1 = sheet.getCell(0, row).getContents();
                        String contents2 = sheet.getCell(1, row).getContents();
                        String contents3 = sheet.getCell(2, row).getContents();
                        String contents4 = sheet.getCell(3, row).getContents();
                        String contents5 = sheet.getCell(4, row).getContents();

                        textView3=(TextView) findViewById(R.id.textView3);
                        textView4=(TextView) findViewById(R.id.textView4);
                        textView5=(TextView) findViewById(R.id.textView5);
                        textView6=(TextView) findViewById(R.id.textView6);
                        textView7=(TextView) findViewById(R.id.textView7);

                        textView3.setText(contents1);
                        textView4.setText(contents2);
                        textView5.setText(contents3);
                        textView6.setText(contents4);
                        textView7.setText(contents5);


                        imageView_f=(ImageView) findViewById(R.id.imageView_flag);
                        imageView_f.setImageResource(R.drawable.f_indonesia);


                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        imageView.setImageResource(R.drawable.c_indonesia);  //국가 이미지 넣기


                        imageView_cardnews=(ImageView) findViewById(R.id.imageView_cardnews);

                        imageView_cardnews.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                                intent.putExtra("국가명", "인도네시아");  //인도네시아
                                startActivity(intent);
                            }
                        });

                    }
                    else if (str2.equals(korea_name)) { //태국

                        toastshow("태국을 선택하셨습니다.");

                        int row = 1; //태국
                        String contents1 = sheet.getCell(0, row).getContents();
                        String contents2 = sheet.getCell(1, row).getContents();
                        String contents3 = sheet.getCell(2, row).getContents();
                        String contents4 = sheet.getCell(3, row).getContents();
                        String contents5 = sheet.getCell(4, row).getContents();

                        textView3=(TextView) findViewById(R.id.textView3);
                        textView4=(TextView) findViewById(R.id.textView4);
                        textView5=(TextView) findViewById(R.id.textView5);
                        textView6=(TextView) findViewById(R.id.textView6);
                        textView7=(TextView) findViewById(R.id.textView7);

                        textView3.setText(contents1);
                        textView4.setText(contents2);
                        textView5.setText(contents3);
                        textView6.setText(contents4);
                        textView7.setText(contents5);

                        imageView_f=(ImageView) findViewById(R.id.imageView_flag);
                        imageView_f.setImageResource(R.drawable.f_tai);


                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        imageView.setImageResource(R.drawable.c_tai);  //국가 이미지 넣기
                        imageView_cardnews=(ImageView) findViewById(R.id.imageView_cardnews);

                        imageView_cardnews.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                                intent.putExtra("국가명", "태국");  //태국
                                startActivity(intent);
                            }
                        });

                    }
                    else if (str3.equals(korea_name)) { //필리핀

                        toastshow("필리핀을 선택하셨습니다.");

                        int row = 2; //필리핀
                        String contents1 = sheet.getCell(0, row).getContents();
                        String contents2 = sheet.getCell(1, row).getContents();
                        String contents3 = sheet.getCell(2, row).getContents();
                        String contents4 = sheet.getCell(3, row).getContents();
                        String contents5 = sheet.getCell(4, row).getContents();

                        textView3=(TextView) findViewById(R.id.textView3);
                        textView4=(TextView) findViewById(R.id.textView4);
                        textView5=(TextView) findViewById(R.id.textView5);
                        textView6=(TextView) findViewById(R.id.textView6);
                        textView7=(TextView) findViewById(R.id.textView7);

                        textView3.setText(contents1);
                        textView4.setText(contents2);
                        textView5.setText(contents3);
                        textView6.setText(contents4);
                        textView7.setText(contents5);


                        imageView_f=(ImageView) findViewById(R.id.imageView_flag);
                        imageView_f.setImageResource(R.drawable.f_ph);


                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        imageView.setImageResource(R.drawable.c_ph);  //국가 이미지 넣기

                        imageView_cardnews=(ImageView) findViewById(R.id.imageView_cardnews);

                        imageView_cardnews.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                                intent.putExtra("국가명", "필리핀");  //필리핀
                                startActivity(intent);
                            }
                        });

                    }
                    else if (str4.equals(korea_name)) { //말레이시아

                        toastshow("말레이시아를 선택하셨습니다.");

                        int row = 3; //말레이시아
                        String contents1 = sheet.getCell(0, row).getContents();
                        String contents2 = sheet.getCell(1, row).getContents();
                        String contents3 = sheet.getCell(2, row).getContents();
                        String contents4 = sheet.getCell(3, row).getContents();
                        String contents5 = sheet.getCell(4, row).getContents();

                        textView3=(TextView) findViewById(R.id.textView3);
                        textView4=(TextView) findViewById(R.id.textView4);
                        textView5=(TextView) findViewById(R.id.textView5);
                        textView6=(TextView) findViewById(R.id.textView6);
                        textView7=(TextView) findViewById(R.id.textView7);

                        textView3.setText(contents1);
                        textView4.setText(contents2);
                        textView5.setText(contents3);
                        textView6.setText(contents4);
                        textView7.setText(contents5);

                        imageView_f=(ImageView) findViewById(R.id.imageView_flag);
                        imageView_f.setImageResource(R.drawable.f_m);


                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        imageView.setImageResource(R.drawable.c_m);  //국가 이미지 넣기
                        imageView_cardnews=(ImageView) findViewById(R.id.imageView_cardnews);

                        imageView_cardnews.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                                intent.putExtra("국가명", "말레이시아");  //말레이시아
                                startActivity(intent);
                            }
                        });

                    }
                    else if (str5.equals(korea_name)) { //싱가포르

                        toastshow("싱가포르를 선택하셨습니다.");

                        int row = 4; //싱가포르
                        String contents1 = sheet.getCell(0, row).getContents();
                        String contents2 = sheet.getCell(1, row).getContents();
                        String contents3 = sheet.getCell(2, row).getContents();
                        String contents4 = sheet.getCell(3, row).getContents();
                        String contents5 = sheet.getCell(4, row).getContents();

                        textView3=(TextView) findViewById(R.id.textView3);
                        textView4=(TextView) findViewById(R.id.textView4);
                        textView5=(TextView) findViewById(R.id.textView5);
                        textView6=(TextView) findViewById(R.id.textView6);
                        textView7=(TextView) findViewById(R.id.textView7);

                        textView3.setText(contents1);
                        textView4.setText(contents2);
                        textView5.setText(contents3);
                        textView6.setText(contents4);
                        textView7.setText(contents5);

                        imageView_f=(ImageView) findViewById(R.id.imageView_flag);
                        imageView_f.setImageResource(R.drawable.f_s);


                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        imageView.setImageResource(R.drawable.c_s);  //국가 이미지 넣기
                        imageView_cardnews=(ImageView) findViewById(R.id.imageView_cardnews);

                        imageView_cardnews.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                                intent.putExtra("국가명", "싱가포르");  //싱가포르
                                startActivity(intent);
                            }
                        });

                    }
                    else if (str6.equals(korea_name)) { //브루나이

                        toastshow("브루나이를 선택하셨습니다.");

                        int row = 5; //브루나이
                        String contents1 = sheet.getCell(0, row).getContents();
                        String contents2 = sheet.getCell(1, row).getContents();
                        String contents3 = sheet.getCell(2, row).getContents();
                        String contents4 = sheet.getCell(3, row).getContents();
                        String contents5 = sheet.getCell(4, row).getContents();

                        textView3=(TextView) findViewById(R.id.textView3);
                        textView4=(TextView) findViewById(R.id.textView4);
                        textView5=(TextView) findViewById(R.id.textView5);
                        textView6=(TextView) findViewById(R.id.textView6);
                        textView7=(TextView) findViewById(R.id.textView7);

                        textView3.setText(contents1);
                        textView4.setText(contents2);
                        textView5.setText(contents3);
                        textView6.setText(contents4);
                        textView7.setText(contents5);


                        imageView_f=(ImageView) findViewById(R.id.imageView_flag);
                        imageView_f.setImageResource(R.drawable.f_b);


                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        imageView.setVisibility(View.INVISIBLE);
                        imageView_cardnews=(ImageView) findViewById(R.id.imageView_cardnews);

                        imageView_cardnews.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                toastshow("브루나이에 대한 카드뉴스는 준비중입니다.\n조금만 기다려주세요 ^^;");
                            }
                        });

                    }
                    else if (str7.equals(korea_name)) { //베트남

                        toastshow("베트남을 선택하셨습니다.");

                        int row = 6; //베트남
                        String contents1 = sheet.getCell(0, row).getContents();
                        String contents2 = sheet.getCell(1, row).getContents();
                        String contents3 = sheet.getCell(2, row).getContents();
                        String contents4 = sheet.getCell(3, row).getContents();
                        String contents5 = sheet.getCell(4, row).getContents();

                        textView3=(TextView) findViewById(R.id.textView3);
                        textView4=(TextView) findViewById(R.id.textView4);
                        textView5=(TextView) findViewById(R.id.textView5);
                        textView6=(TextView) findViewById(R.id.textView6);
                        textView7=(TextView) findViewById(R.id.textView7);

                        textView3.setText(contents1);
                        textView4.setText(contents2);
                        textView5.setText(contents3);
                        textView6.setText(contents4);
                        textView7.setText(contents5);
                        imageView_f=(ImageView) findViewById(R.id.imageView_flag);
                        imageView_f.setImageResource(R.drawable.f_viet);


                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        imageView.setImageResource(R.drawable.c_viet);  //국가 이미지 넣기
                        imageView_cardnews=(ImageView) findViewById(R.id.imageView_cardnews);

                        imageView_cardnews.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                                intent.putExtra("국가명", "베트남");  //베트남
                                startActivity(intent);
                            }
                        });


                    }
                    else if (str8.equals(korea_name)) { //라오스

                        toastshow("라오스를 선택하셨습니다.");

                        int row = 7; //라오스
                        String contents1 = sheet.getCell(0, row).getContents();
                        String contents2 = sheet.getCell(1, row).getContents();
                        String contents3 = sheet.getCell(2, row).getContents();
                        String contents4 = sheet.getCell(3, row).getContents();
                        String contents5 = sheet.getCell(4, row).getContents();

                        textView3=(TextView) findViewById(R.id.textView3);
                        textView4=(TextView) findViewById(R.id.textView4);
                        textView5=(TextView) findViewById(R.id.textView5);
                        textView6=(TextView) findViewById(R.id.textView6);
                        textView7=(TextView) findViewById(R.id.textView7);

                        textView3.setText(contents1);
                        textView4.setText(contents2);
                        textView5.setText(contents3);
                        textView6.setText(contents4);
                        textView7.setText(contents5);

                        imageView_f=(ImageView) findViewById(R.id.imageView_flag);
                        imageView_f.setImageResource(R.drawable.f_ra);


                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        imageView.setImageResource(R.drawable.c_ra);  //국가 이미지 넣기
                        imageView_cardnews=(ImageView) findViewById(R.id.imageView_cardnews);

                        imageView_cardnews.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                                intent.putExtra("국가명", "라오스");  //라오스
                                startActivity(intent);
                            }
                        });

                    }
                    else if (str9.equals(korea_name)) { //미얀마

                        toastshow("미얀마를 선택하셨습니다.");

                        int row = 8; //미얀마
                        String contents1 = sheet.getCell(0, row).getContents();
                        String contents2 = sheet.getCell(1, row).getContents();
                        String contents3 = sheet.getCell(2, row).getContents();
                        String contents4 = sheet.getCell(3, row).getContents();
                        String contents5 = sheet.getCell(4, row).getContents();

                        textView3=(TextView) findViewById(R.id.textView3);
                        textView4=(TextView) findViewById(R.id.textView4);
                        textView5=(TextView) findViewById(R.id.textView5);
                        textView6=(TextView) findViewById(R.id.textView6);
                        textView7=(TextView) findViewById(R.id.textView7);

                        textView3.setText(contents1);
                        textView4.setText(contents2);
                        textView5.setText(contents3);
                        textView6.setText(contents4);
                        textView7.setText(contents5);


                        imageView_f=(ImageView) findViewById(R.id.imageView_flag);
                        imageView_f.setImageResource(R.drawable.f_mi);

                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        imageView.setImageResource(R.drawable.c_mi);  //국가 이미지 넣기

                        imageView_cardnews=(ImageView) findViewById(R.id.imageView_cardnews);

                        imageView_cardnews.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                                intent.putExtra("국가명", "미얀마");  //미얀마
                                startActivity(intent);
                            }
                        });

                    }
                    else if (str10.equals(korea_name)) { //캄보디아

                        toastshow("캄보디아를 선택하셨습니다.");

                        int row = 9; //캄보디아
                        String contents1 = sheet.getCell(0, row).getContents();
                        String contents2 = sheet.getCell(1, row).getContents();
                        String contents3 = sheet.getCell(2, row).getContents();
                        String contents4 = sheet.getCell(3, row).getContents();
                        String contents5 = sheet.getCell(4, row).getContents();

                        textView3=(TextView) findViewById(R.id.textView3);
                        textView4=(TextView) findViewById(R.id.textView4);
                        textView5=(TextView) findViewById(R.id.textView5);
                        textView6=(TextView) findViewById(R.id.textView6);
                        textView7=(TextView) findViewById(R.id.textView7);

                        textView3.setText(contents1);
                        textView4.setText(contents2);
                        textView5.setText(contents3);
                        textView6.setText(contents4);
                        textView7.setText(contents5);

                        imageView_f=(ImageView) findViewById(R.id.imageView_flag);
                        imageView_f.setImageResource(R.drawable.f_cam);


                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        imageView.setImageResource(R.drawable.c_cam);  //국가 이미지 넣기
                        imageView_cardnews=(ImageView) findViewById(R.id.imageView_cardnews);

                        imageView_cardnews.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                                intent.putExtra("국가명", "캄보디아");  //캄보디아
                                startActivity(intent);
                            }
                        });

                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

    }

    public void toastshow(String e) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout));
        TextView text = layout.findViewById(R.id.text);
        Toast toast = new Toast(getApplicationContext());
        text.setText(e);
        text.setTextSize(15);
        text.setTextColor(Color.WHITE);
        toast.setGravity(Gravity.BOTTOM,0,100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show(); }

}
