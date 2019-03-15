package com.example.yhch.app2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
            /**
             * Intent 组件交互
             * 1.指明组件要执行的活动
             * 2.组件之间传递数据
             *
             * 应用:启动活动，启动服务，发送广播
             *
             * 实现方式:显式intent 隐式intent
             * @param v
             */
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"you click button 1",Toast.LENGTH_SHORT).show();
                //finish();
                //显式Intent
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivity(intent);

                //隐式Intent
//                Intent intent = new Intent("com.example.yhch.app2.FirstActivity.ACTION_START");
//                intent.addCategory("com.example.yhch.app2.FirstActivity.MY_CATEGORY");
//                startActivity(intent);

                /**
                 *  调用系统浏览器打开网页
                 *
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://yhch.xyz"));
                startActivity(intent);
                **/

                /** 调用系统拨号界面
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10000"));
                startActivity(intent);
                 **/

                /** 通过intent 向下一活动传递值
                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
                 **/

                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);




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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (requestCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnData);
                }
                break;
            default:
        }
    }
}
