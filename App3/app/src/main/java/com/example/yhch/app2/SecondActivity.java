package com.example.yhch.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","from second to first,Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        /**  获取上一活动的值

        //获取用于启动此活动的Intent
        Intent intent = getIntent();
        //用键获取值
        String data = intent.getStringExtra("extra_data");
        Log.d("SencondActivity",data);

        **/

        /** 向上一活动传递数据
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return","from second to first,Hello FirstActivity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
         **/




    }
}
