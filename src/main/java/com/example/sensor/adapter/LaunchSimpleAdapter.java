package com.example.sensor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.sensor.R;

import java.util.ArrayList;

public class LaunchSimpleAdapter extends PagerAdapter {

    private ArrayList<View> viewArrayList = new ArrayList<>();
    private Context context;

    public LaunchSimpleAdapter(Context context, int[] imageArray) {
        this.context = context;
        for (int i = 0; i < imageArray.length; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_launch,null);
            ImageView imageView = view.findViewById(R.id.iv_launch);
            imageView.setImageResource(imageArray[i]);
            viewArrayList.add(view);
        }
    }

    @Override
    public int getCount() {
        return viewArrayList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewArrayList.get(position));
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(viewArrayList.get(position));
        return viewArrayList.get(position);
    }
}
