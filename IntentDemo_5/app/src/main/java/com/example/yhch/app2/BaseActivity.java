package com.example.yhch.app2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //输出当前实例名
        Log.d("BaseActivity",getClass().getSimpleName());
        ActivityColler.addActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityColler.removeActivity(this);
    }
}
