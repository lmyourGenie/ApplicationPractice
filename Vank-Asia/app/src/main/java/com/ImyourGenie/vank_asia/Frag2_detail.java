package com.ImyourGenie.vank_asia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.internal.e;

import org.w3c.dom.Text;

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

    ImageView imageView;


    // 링크걸기참고 https://hongku.tistory.com/205

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_country);
        Excel();

/*




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

*/

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

                        toastshow("인도네시아를 안내합니다!");

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

                        imageView=(ImageView) findViewById(R.id.imageView_country);
                        //imageView.setImage(~~~~~);  국가 이미지 넣기

                        imageView.setOnClickListener(new AdapterView.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                                intent.putExtra("국가명", "인도네시아");  //인도네시아
                                startActivity(intent);
                            }
                        });

                    }
/*
                } else if (str2.equals(korea_name)) { //태국
                    for (int row = rowIndexStart; row < rowTotal; row++) {
                        sb = new StringBuilder();
                        int col = 1;
                        String contents = sheet.getCell(col, row).getContents();
                        sb.append("col" + col + " : " + contents + " , ");

                        Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);
                        intent.putExtra("국가명", "태국");
                        startActivity(intent);
                    }
                } else if (str3.equals(korea_name)) { //필리핀

                } else if (str4.equals(korea_name)) { //말레이시아

                } else if (str5.equals(korea_name)) { //싱가포르

                } else if (str6.equals(korea_name)) { //브루나이

                } else if (str7.equals(korea_name)) { //베트남

                } else if (str8.equals(korea_name)) { //라오스

                } else if (str9.equals(korea_name)) { //미얀마

                } else if (str10.equals(korea_name)) { //캄보디아

                }
*/
/*  클릭시 인텐트 넘기면 됨
                       긍까 이미지에 클릭 이벤트 넣고 인텐트 보내면됨
                        Intent intent = new Intent(Frag2_detail.this, Frag2_detail_detail.class);


                        intent.putExtra("국가명", contents1);
                        startActivity(intent);
                        */
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
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show(); }


}
