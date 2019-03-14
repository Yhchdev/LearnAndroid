package com.example.yhch.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 1.创建活动
 * 2.res/layout——>创建布局文件
 * 3.引入布局文件
 * 4.注册活动使之生效——>指明主活动，程序的入口
 *
 * 5.Toast.makeText(1.活动本身，2."弹出的内容",3.显示时长)
 */
public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,"you click button 1",Toast.LENGTH_SHORT).show();
                //finish();
            }
        });
    }


    /*
    菜单选项
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you click Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you click Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        //return super.onOptionsItemSelected(item);
        return true;
    }

    /**
     * 为活动创建菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }
}
