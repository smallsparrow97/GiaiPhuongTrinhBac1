package com.gameloft.pc.giaiphuongtrinhbac1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    TextView txtKetQua;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtKetQua=(TextView)findViewById(R.id.txtKetQua);
        btnBack=(Button)findViewById(R.id.btnBack);

        //get lấy intent đã gọi từ ResultActivity
        Intent callerIntent=getIntent();

        //get bundle đã gửi sang
        Bundle packBundle=callerIntent.getBundleExtra("MyPackage");

        //get giá trị a, b đã chuyển sang
        final int a=packBundle.getInt("soA");
        final int b=packBundle.getInt("soB");

        giaiPTBN(a, b);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent2=new Intent(ResultActivity.this, MainActivity.class);

                String noiDungThongBao= String.format("Wellcome back to MainActivity ! Your last edit text : a=  %d, b= %d", a, b);
                Toast.makeText(ResultActivity.this, noiDungThongBao,Toast.LENGTH_LONG).show();

                startActivity(myIntent2);


            }
        });
    }
    public void giaiPTBN(int a, int b)
    {
        if (a==0)
            if(b==0) {
                txtKetQua.setText("Phương trình vô số nghiệm");
                return;
            }
            else
                txtKetQua.setText("Phương trình vô nghiệm");
        else txtKetQua.setText(String.valueOf((float)-b/a));
    }

}
