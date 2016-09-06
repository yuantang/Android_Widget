package com.coder.tom.androidtips;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    /** TAG */
    private final static String TAG = "CustomActivity";
    /** 按钮：显示自定义通知 */
    private Button btn_show_custom;
    /** 按钮：显示自定义带按钮的通知 */
    private Button btn_show_custom_button;
    /** Notification 的ID */
    int notifyId = 101;
    /** NotificationCompat 构造器*/
    NotificationCompat.Builder mBuilder;
    /** 是否在播放*/
    public boolean isPlay = false;

    /** 通知栏按钮点击事件对应的ACTION */
    public final static String ACTION_BUTTON = "com.notifications.intent.action.ButtonClick";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.notification_txt,R.id.notification_custom_txt})
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.notification_txt:
                Intent intent=new Intent(this,MainActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(this,RESULT_OK,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder= new NotificationCompat.Builder(getBaseContext());
                Notification notification=builder.setContentTitle("通知标题")//设置标题
                        .setContentText("通知标题")//设置通知内容
                        .setContentIntent(pendingIntent)
                        .setWhen(System.currentTimeMillis())//显示当前系统时间
//              .setShowWhen(false)//不显示时间
                        .setSmallIcon(R.mipmap.ic_launcher)//设置小图标
                        .setColor(Color.parseColor("#8DC24D"))//设置小图标的颜色
                        .setLargeIcon(BitmapFactory.decodeResource(  //如果不设置setLargeIcon，则小图标会显示在大图标的位置
                                getResources(), R.mipmap.ic_launcher))
                        .setAutoCancel(true)//设置当用户单击面板就可以让通知自动取消
                        .build();
                manager.notify(1,notification);//发送通知
//      manager.cancel();//移除通知
                break;
            case R.id.notification_custom_txt:
//                Intent intent2=new Intent(this,MainActivity.class);
//                PendingIntent pendingIntent2=PendingIntent.getActivity(this,RESULT_OK,intent2,PendingIntent.FLAG_UPDATE_CURRENT);
//                RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.layout_notification_custom_white);
//
//                remoteViews.setImageViewResource(R.id.custom_icon,R.mipmap.ic_launcher);
//                remoteViews.setTextViewText(R.id.tv_custom_title,"自定义通知Title");
//                remoteViews.setTextViewText(R.id.tv_custom_content,"自定义通知Content");
//                remoteViews.setTextViewText(R.id.tv_custom_time,String.valueOf(System.currentTimeMillis()));
//
//                NotificationManager manager2= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                NotificationCompat.Builder builder2= new NotificationCompat.Builder(getBaseContext());
//                Notification notification2=builder2
////                        .setContentTitle("通知标题")//设置标题
////                        .setContentText("通知标题")//设置通知内容
//                        .setContentIntent(pendingIntent2)
//                        .setContent(remoteViews)//自定义view
//                        .setWhen(System.currentTimeMillis())//显示当前系统时间
////                      .setShowWhen(false)//不显示时间
//                        .setSmallIcon(R.mipmap.ic_launcher)//设置小图标
////                        .setColor(Color.parseColor("#8DC24D"))//设置小图标的颜色
////                        .setLargeIcon(BitmapFactory.decodeResource(  //如果不设置setLargeIcon，则小图标会显示在大图标的位置
////                                getResources(), R.mipmap.ic_launcher))
//                        .setAutoCancel(true)//设置当用户单击面板就可以让通知自动取消
//                        .build();
//                manager2.notify(1,notification2);//发送通知
////                Notification.FLAG_SHOW_LIGHTS              //三色灯提醒，在使用三色灯提醒时候必须加该标志符
////                Notification.FLAG_ONGOING_EVENT          //发起正在运行事件（活动中）
////                Notification.FLAG_INSISTENT   //让声音、振动无限循环，直到用户响应 （取消或者打开）
////                Notification.FLAG_ONLY_ALERT_ONCE  //发起Notification后，铃声和震动均只执行一次
////                Notification.FLAG_AUTO_CANCEL      //用户单击通知后自动消失
////                Notification.FLAG_NO_CLEAR          //只有全部清除时，Notification才会清除 ，不清楚该通知(QQ的通知无法清除，就是用的这个)
////                Notification.FLAG_FOREGROUND_SERVICE    //表示正在运行的服务
////      manager.cancel();//移除通知
                shwoNotify();
                break;
        }
    }

    public void shwoNotify(){
        Intent intent2=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent2=PendingIntent.getActivity(this,RESULT_OK,intent2,PendingIntent.FLAG_UPDATE_CURRENT);
        //先设定RemoteViews
        RemoteViews view_custom = new RemoteViews(getPackageName(), R.layout.view_custom);
        //设置对应IMAGEVIEW的ID的资源图片
        view_custom.setImageViewResource(R.id.custom_icon, R.mipmap.ic_launcher);
//		view_custom.setInt(R.id.custom_icon,"setBackgroundResource",R.drawable.icon);
        view_custom.setTextViewText(R.id.tv_custom_title, "今日头条");
        view_custom.setTextViewText(R.id.tv_custom_content, "金州勇士官方宣布球队。");
		view_custom.setTextViewText(R.id.tv_custom_time, String.valueOf(System.currentTimeMillis()));
        //设置显示
//		view_custom.setViewVisibility(R.id.tv_custom_time, View.VISIBLE);
//		view_custom.setLong(R.id.tv_custom_time,"setTime", System.currentTimeMillis());//不知道为啥会报错，过会看看日志
        //设置number
//		NumberFormat num = NumberFormat.getIntegerInstance();
//		view_custom.setTextViewText(R.id.tv_custom_num, num.format(this.number));
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContent(view_custom)
                .setContentIntent(pendingIntent2)
                .setWhen(System.currentTimeMillis())// 通知产生的时间，会在通知信息里显示
                .setTicker("有新资讯")
                .setPriority(Notification.PRIORITY_DEFAULT)// 设置该通知优先级
                .setOngoing(false)//不是正在进行的   true为正在进行  效果和.flag一样
                .setSmallIcon(R.mipmap.ic_launcher);
//		mNotificationManager.notify(notifyId, mBuilder.build());
        Notification notify = mBuilder.build();
        notify.contentView = view_custom;
//		Notification notify = new Notification();
//		notify.icon = R.drawable.icon;
//		notify.contentView = view_custom;
//		notify.contentIntent = getDefalutIntent(Notification.FLAG_AUTO_CANCEL);
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(notifyId, notify);
    }

}
