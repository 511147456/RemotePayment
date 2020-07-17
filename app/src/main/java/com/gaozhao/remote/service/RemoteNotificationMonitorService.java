package com.gaozhao.remote.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.Toast;

/**
 *
 * Author by GaoZhao in RemotePayment
 * Email 18093546728@163.com
 * https://me.csdn.net/gao511147456
 * 安卓通知拦截
 *
 */

@SuppressLint("NewApi")
public class RemoteNotificationMonitorService extends NotificationListenerService {

    //在收到消息时触发
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        // TODO Auto-generated method stub
        Bundle extras = sbn.getNotification().extras;
        // 获取接收消息APP的包名
        String notificationPkg = sbn.getPackageName();
        // 获取接收消息的抬头
        String notificationTitle =
                extras.getString(Notification.EXTRA_TITLE);
        // 获取接收消息的内容
        String notificationText = extras.getString(Notification.EXTRA_TEXT);
        Log.i("XSL_Test", "Notification posted " + notificationTitle + " & " + notificationText);
        Toast.makeText(RemoteNotificationMonitorService.this, "show_content:" +
                        "Notification posted " + notificationTitle + " & " + notificationText
                , Toast.LENGTH_LONG).show();
    }

    // 在删除消息时触发
    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {

        // TODO Auto-generated method stub
        Bundle extras = sbn.getNotification().extras;
        // 获取接收消息APP的包名
        String notificationPkg = sbn.getPackageName();
        // 获取接收消息的抬头
        String notificationTitle = extras.getString(Notification.EXTRA_TITLE);
        // 获取接收消息的内容
        String notificationText = extras.getString(Notification.EXTRA_TEXT);
        Log.i("XSL_Test", "Notification removed " + notificationTitle + " & " + notificationText);
        Toast.makeText(RemoteNotificationMonitorService.this, "show_content:" +
                        "Notification removed " + notificationTitle + " & " + notificationText
                , Toast.LENGTH_LONG).show();
    }


}
