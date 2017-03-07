package com.example.thannathrnyuwasin.thefar;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.thannathrnyuwasin.thefar.Service.MyService;

import static android.content.Context.ALARM_SERVICE;
import static com.example.thannathrnyuwasin.thefar.R.styleable.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private int[] image = {R.drawable.s_pic1,R.drawable.s_pic2,R.drawable.s_pic3};
    private Handler handler = new Handler();
    private PendingIntent pIntent;
    private AlarmManager alarm;
    private int time;
    String[] message = {"คุณได้รับข้อความใหม่", "กรุณากดเพื่อดูข้อความ"
            , "กรุณากดเพื่อดูข้อความ", "กรุณากดเพื่อดูข้อความ"
            , "กรุณากดเพื่อดูข้อความ", "กรุณากดเพื่อดูข้อความ"};

    @TargetApi(24)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setOffscreenPageLimit(1);
        pager.setAdapter(new InfiniteAdapter(this,image));



        /*handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Log.i("Pager", String.valueOf(pager.getCurrentItem() + 1));
                pager.setCurrentItem(pager.getCurrentItem() + 1);
                handler.postDelayed(this,3000);

            }
        },5000);*/


        ImageView start = (ImageView) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("เรียนรู้ประวัติศาสตร์มุมสู๊งสูง");
                builder.setMessage("กรุณาเลือกไฟค์การเดินทางของท่าน");
                builder.setIcon(R.drawable.testlogo);
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent add = new Intent(getApplicationContext(),   Figth.class);
                        startActivity(add);
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        ImageView nokasia = (ImageView) findViewById(R.id.point);
        nokasia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(getApplicationContext(), Tabbar_par.class);
                startActivity(add);

            }
        });

        time = 10000;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                pIntent = PendingIntent.getService(MainActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarm.set(AlarmManager.RTC, time, pIntent);


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

/**
 * Created by thannathrnyuwasin on 4/11/59.
 */

