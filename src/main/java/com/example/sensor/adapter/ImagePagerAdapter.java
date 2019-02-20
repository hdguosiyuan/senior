package com.example.sensor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.sensor.bean.GoodInfo;

import java.util.ArrayList;

public class ImagePagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<ImageView> mViewList = new ArrayList<>();
    private ArrayList<GoodInfo> mGoodInfo = new ArrayList<>();

    public ImagePagerAdapter(Context context, ArrayList<GoodInfo> arrayList) {
        mGoodInfo = arrayList;
        mContext = context;
        for(int i = 0;i<mGoodInfo.size();i++){
            ImageView view = new ImageView(mContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            view.setImageResource(mGoodInfo.get(i).pic);
            mViewList.add(view);
        }
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mViewList.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public String getPageTitle(int position){
        return mGoodInfo.get(position).name;
    }
}
