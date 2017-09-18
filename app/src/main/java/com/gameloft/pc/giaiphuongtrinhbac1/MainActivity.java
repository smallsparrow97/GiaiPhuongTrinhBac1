package com.gameloft.pc.giaiphuongtrinhbac1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;



import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    Button btnKetQua;
    EditText edtA, edtB, edtA2, edtB2;

    static String a="";
    static String b="";

    //cách 2 để xử lý lỗi định dạng nhập số
    /*public static boolean isNumberic(String str) {
        return str.matches("[+-]?\\d+");
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKetQua=(Button)findViewById(R.id.btnKetQua);
        edtA=(EditText)findViewById(R.id.edtA);
        edtB=(EditText)findViewById(R.id.edtB);

        edtA.setText(a);
        edtB.setText(b);

        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //tạo intent để mở class ResultActivity
                Intent myIntent=new Intent(MainActivity.this, ResultActivity.class);

                try {
                    int a= parseInt(edtA.getText().toString());
                    int b= parseInt(edtB.getText().toString());


                    //khai báo bundle để đóng gói dữ liệu gửi sang ResultActivity
                    Bundle bundle=new Bundle();
                    bundle.putInt("soA", a);//đưa dữ liệu đơn lẻ vào bundle
                    bundle.putInt("soB", b);//"soB" là key, b là value

                    //đưa bundle vào intent
                    myIntent.putExtra("MyPackage",bundle);

                    //mở ResultActivity thông qua intent
                    startActivity(myIntent);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(MainActivity.this, "Bạn phải nhập số nguyên!", Toast.LENGTH_SHORT).show();
                }

                a="0";
                b="0";


                //cách 2 để xử lý lỗi định dạng nhập số
                /*String A= String.valueOf(edtA.getText());
                String B= String.valueOf(edtB.getText());
                if (!isNumberic(A) ||!isNumberic(B)|| A.length()==0 || B.length()==0) {
                    Toast.makeText(MainActivity.this, "Bạn phải nhập số nguyên!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int a= parseInt(edtA.getText().toString());
                    int b= parseInt(edtB.getText().toString());


                    //khai báo bundle để đóng gói dữ liệu gửi sang ResultActivity
                    Bundle bundle=new Bundle();
                    bundle.putInt("soA", a);//đưa dữ liệu đơn lẻ vào bundle
                    bundle.putInt("soB", b);//"soB" là key, b là value

                    //đưa bundle vào intent
                    myIntent.putExtra("MyPackage",bundle);

                    //mở ResultActivity thông qua intent
                    startActivity(myIntent);
                }*/

            }
        });


    }
}
