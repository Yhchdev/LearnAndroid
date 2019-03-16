package com.example.yhch.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_third);

        Button button_3 = findViewById(R.id.button_3);

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityColler.finishAll();
            }
        });
    }
}
