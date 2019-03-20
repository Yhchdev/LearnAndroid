package yhch.xyz.broadcastbestpractice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private ForceofflineReceive receive;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }


    //活动位于栈顶时
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("yhch.xyz.broadcastbestpractice.FORCE_OFFLINE");
        receive = new ForceofflineReceive();
        registerReceiver(receive,intentFilter);
    }

    //活动不可见时
    @Override
    protected void onPause() {
        super.onPause();
        if(receive !=null){
            unregisterReceiver(receive);//失去栈顶位置，取消注册,非栈顶活动没必要接收这条广播
            receive =null;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class ForceofflineReceive extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, final Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Waring");
            builder.setMessage("你已在令一台设备登录,请下线重新登录");
            builder.setCancelable(false);
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll(); //销毁所有活动
                    Intent intent1 = new Intent(context,LoginActivity.class);
                    startActivity(intent1); // 重启登录界面
                }
            });
            builder.show();
        }
    }
}
