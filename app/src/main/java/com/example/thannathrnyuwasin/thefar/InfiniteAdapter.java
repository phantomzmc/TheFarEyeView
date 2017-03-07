package com.example.thannathrnyuwasin.thefar;

/**
 * Created by thannathrnyuwasin on 12/8/2016 AD.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class InfiniteAdapter extends PagerAdapter {
    private Context activity;
    private int[] image;
    private int pos = 0;

    public InfiniteAdapter(Context activity,int[] image){
        this.activity = activity;
        this.image = image;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView img = new ImageView(activity);
        container.addView(img);
        img.setImageResource(image[pos]);

        if(pos >= image.length - 1)
            pos =0;
        else
            ++pos;

        Log.i("Posittion",pos+"");
        return img;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }


}