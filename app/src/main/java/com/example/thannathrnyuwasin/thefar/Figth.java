package com.example.thannathrnyuwasin.thefar;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.thannathrnyuwasin.thefar.Service.MyService;
import com.example.thannathrnyuwasin.thefar.Service.MyService2;

/**
 * Created by thannathrnyuwasin on 12/8/2016 AD.
 */

public class Figth extends AppCompatActivity {

    private int time;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight);

        time = 10000;
        ImageView fight1 = (ImageView) findViewById(R.id.imageView);
        fight1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Figth.this);
                builder.setTitle(R.string.title_alert);
                builder.setMessage("ท่านได้เริ่มการเดินทางเเล้ว.....กรุณารอการเเจ้งเตือนครั้งต่อไป");
                builder.setIcon(R.drawable.v_cm);
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Figth.this, MyService.class);
                        PendingIntent pIntent = PendingIntent.getService(Figth.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarm.set(AlarmManager.RTC, time, pIntent);
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        time = 5000;
        ImageView fight2 = (ImageView) findViewById(R.id.imageView2);
        fight2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Figth.this);
                builder.setTitle("ชื่อ App");
                builder.setMessage("ขณะนี้กำลังเข้าสู่จังหวัดสุโขทัย");
                builder.setIcon(R.drawable.v_cm);
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Figth.this, MyService2.class);
                        PendingIntent pIntent = PendingIntent.getService(Figth.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarm.set(AlarmManager.RTC, time, pIntent);
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }
}