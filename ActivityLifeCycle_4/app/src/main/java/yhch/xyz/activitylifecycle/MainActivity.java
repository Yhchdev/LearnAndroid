package yhch.xyz.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_main);
        //判断之前有无保存数据
        if(savedInstanceState!=null){
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG,tempData);
        }

        Button button_n = findViewById(R.id.start_normal);
        Button button_d = findViewById(R.id.start_dialog);

        button_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        button_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG,"onResume");
    }

    //保存数据，在oncreate的时候返回
    @Override
    //活动回收之前，将数据保存
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        String data = "我是之前保存的数据";
        outState.putString("data_key", data);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"销毁");
    }
}
