package com.example.thannathrnyuwasin.thefar.Park;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.thannathrnyuwasin.thefar.InfiniteAdapter;
import com.example.thannathrnyuwasin.thefar.R;

/**
 * Created by thannathrnyuwasin on 12/9/2016 AD.
 */

public class Park4 extends AppCompatActivity {
    private ViewPager pager;
    private int[] image = {R.drawable.inthanon, R.drawable.inthanon2};
    private Handler handler = new Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.park_layout);

        TextView title = (TextView) findViewById(R.id.textView);
        title.setText(R.string.t_park4);
        TextView detail = (TextView) findViewById(R.id.textView2);
        detail.setText(R.string.d_park4);


        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setOffscreenPageLimit(1);
        pager.setAdapter(new InfiniteAdapter(this, image));


        /*handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Log.i("Pager", String.valueOf(pager.getCurrentItem() + 1));
                pager.setCurrentItem(pager.getCurrentItem() + 1);
                handler.postDelayed(this, 3000);

            }
        }, 5000);*/
    }
}