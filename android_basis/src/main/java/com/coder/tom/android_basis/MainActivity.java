package com.coder.tom.android_basis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coder.tom.android_basis.service.ServiceActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    LinearLayout l;
    RelativeLayout r;
    @Bind(R.id.activity_txt)
    TextView activityTxt;
    @Bind(R.id.service_txt)
    TextView serviceTxt;
    @Bind(R.id.contentprovider_txt)
    TextView contentproviderTxt;
    @Bind(R.id.broadcastreceiver_txt)
    TextView broadcastreceiverTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.activity_txt, R.id.service_txt, R.id.contentprovider_txt, R.id.broadcastreceiver_txt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_txt:
                break;
            case R.id.service_txt:
                startActivity(new Intent(MainActivity.this, ServiceActivity.class));
                break;
            case R.id.contentprovider_txt:

                break;
            case R.id.broadcastreceiver_txt:

                break;
        }
    }
}
