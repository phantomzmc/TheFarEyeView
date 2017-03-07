package com.example.thannathrnyuwasin.thefar.Service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;

import com.example.thannathrnyuwasin.thefar.List1.MainActivityList;
import com.example.thannathrnyuwasin.thefar.MainActivity;
import com.example.thannathrnyuwasin.thefar.R;

/**
 * Created by IamDeveloper on 10/24/2016.
 */
public class MyService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    String text1 = "กำลังเข้าสู่เมืองกรุงศรีอยุธยา";


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(MyService.this);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();

        notification.setSmallIcon(R.drawable.appstelegram);
        notification.setAutoCancel(true);
        notification.setContentTitle("แอพพลิเคชั่นการเรียนรู้ประวัติศาสตร์มุมสู๊งสูง");
        notification.setContentText("เมืองต่อไปของท่าน");
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(this.getResources(), R.drawable.v_cm));
        bigPictureStyle.setBigContentTitle(text1);
        notification.setStyle(bigPictureStyle);


        Intent i = new Intent(MyService.this, MainActivityList.class);
        TaskStackBuilder builder = TaskStackBuilder.create(MyService.this);
        builder.addParentStack(MainActivity.class);
        builder.addNextIntent(i);

        PendingIntent pIntent = builder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(11221,notification.build());
        return super.onStartCommand(intent, flags, startId);

    }
}
