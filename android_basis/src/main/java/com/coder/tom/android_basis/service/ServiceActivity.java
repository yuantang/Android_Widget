package com.coder.tom.android_basis.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.coder.tom.android_basis.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceActivity extends AppCompatActivity {

    @Bind(R.id.startService_txt)
    TextView startServiceTxt;
    @Bind(R.id.stopService_txt)
    TextView stopServiceTxt;
    @Bind(R.id.bindService_txt)
    TextView bindServiceTxt;
    @Bind(R.id.unbindService_txt)
    TextView unbindServiceTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
    }
    private   ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Toast.makeText(ServiceActivity.this,"连接成功",Toast.LENGTH_SHORT).show();
            Log.d("Service", "连接成功！");
        }
        //.类ServiceConnection中的onServiceDisconnected()方法在正常情况下是不被调用的，它的调用时机是当Service服务被异外销毁时，例如内存的资源不足时这个方法才被自动调用
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("Service", "断开连接！");
            Toast.makeText(ServiceActivity.this,"断开成功",Toast.LENGTH_SHORT).show();
        }
    };
    @OnClick({ R.id.stopService_txt, R.id.startService_txt, R.id.bindService_txt, R.id.unbindService_txt})
    public void onClick(View view) {
        Intent start=new Intent(ServiceActivity.this,ServService.class);
        switch (view.getId()) {
            case R.id.startService_txt:
                startService(start);
                break;
            case R.id.stopService_txt:
                stopService(start);
                break;
            case R.id.bindService_txt:
                bindService(start,serviceConnection, Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbindService_txt:
                unbindService(serviceConnection);
                break;
        }
    }
}
