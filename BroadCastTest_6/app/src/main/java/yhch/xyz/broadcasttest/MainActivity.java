package yhch.xyz.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * 1.动态注册广播
 * 2.广播接收器类 继承BroadcastReceiver类 并重写其方法.
 */

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private static final String TAG = "MainActivity";

    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        //获取实例
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** 动态注册广播和自定义广播
                Log.d(TAG,"你点击了我");
                Intent intent =
                        new Intent("yhch.xyz.broadcasttest.MY_BROADCAST");
                //sendBroadcast(intent);

                //android8接受自定义广播，静态注册时新增内容
                intent.setComponent(new ComponentName("yhch.xyz.broadcasttest","yhch.xyz.broadcasttest.MyBroadcastReceiver"));
                //标准广播
                sendBroadcast(intent);


                // sendOrderedBroadcast(intent,null);

                 **/

                /**
                 * 本地广播
                 */
                Intent intent = new Intent("yhch.xyz.broadcasttest.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);

            }
        });

        intentFilter = new IntentFilter();
        /**
        //接受的广播类型
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //注册广播接收器(1.接收器类,2.intentFilter)
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
         **/

        //注册本地广播接收器
        intentFilter.addAction("yhch.xyz.broadcasttest.LOCAL_BROADCAST");

        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册接收器
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if(networkInfo !=null && networkInfo.isAvailable()){
                Toast.makeText(context,"当前网络是可用的",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"network is unAvailable",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
