package yhch.xyz.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.save_data);

        Button btn_Restore = findViewById(R.id.get_data);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.获取sharedPreferences对象
                SharedPreferences.Editor editor =
                        getSharedPreferences("data",MODE_PRIVATE).edit();

                //2.添加数据
                editor.putString("name","杨浩成");
                editor.putInt("age",22);
                editor.putBoolean("isStudent",true);

                //3.提交数据
                editor.apply();
            }
        });


        btn_Restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spf = getSharedPreferences("data", MODE_PRIVATE);
                String name = spf.getString("name","");
                int age = spf.getInt("age",0);
                boolean student = spf.getBoolean("isStudent",false);

                Log.d("MainActivity", "name is"+name);
                Log.d("MainActivity", "age is"+age);
                Log.d("MainActivity", "is a student"+student);
            }
        });


    }
}
