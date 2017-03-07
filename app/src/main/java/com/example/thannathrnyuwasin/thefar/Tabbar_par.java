package com.example.thannathrnyuwasin.thefar;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


import com.example.thannathrnyuwasin.thefar.List1.MainActivityList;
import com.example.thannathrnyuwasin.thefar.List1.MainActivityList2;
import com.example.thannathrnyuwasin.thefar.Park.Park1;
import com.example.thannathrnyuwasin.thefar.Park.Park2;
import com.example.thannathrnyuwasin.thefar.Park.Park3;
import com.example.thannathrnyuwasin.thefar.Park.Park4;

/**
 * Created by thannathrnyuwasin on 12/9/2016 AD.
 */

public class Tabbar_par extends Activity {
    LocalActivityManager mLocalActivityManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabbar_park);
        mLocalActivityManager = new LocalActivityManager(this, false);
        mLocalActivityManager.dispatchCreate(savedInstanceState);

        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup(mLocalActivityManager);

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab1")
                .setIndicator("เชียงดาว")
                .setContent(new Intent(this, MainActivityList.class));

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2")
                .setIndicator("อุทยานเเห่งชาติเเม่ฟาง")
                .setContent(new Intent(this, MainActivityList2.class));

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3")
                .setIndicator("อุทยานเเห่งชาติออบหลวง")
                .setContent(new Intent(this, Park3.class));
        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("tab4")
                .setIndicator("ดอยอินทนนท์")
                .setContent(new Intent(this, Park4.class));

        tabHost.addTab(tabSpec);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
        tabHost.addTab(tabSpec4);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocalActivityManager.dispatchPause(!isFinishing());

    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocalActivityManager.dispatchResume();
    }

}

