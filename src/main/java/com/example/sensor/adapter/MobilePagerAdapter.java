package com.example.sensor.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sensor.bean.GoodInfo;
import com.example.sensor.fragment.DynamicFragment;

import java.util.ArrayList;

public class MobilePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<GoodInfo> mGoodList = new ArrayList<>();

    public MobilePagerAdapter(FragmentManager fm, ArrayList<GoodInfo> arrayList) {
        super(fm);
        mGoodList = arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return DynamicFragment.newInstance(position, mGoodList);
    }

    @Override
    public int getCount() {
        return mGoodList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mGoodList.get(position).name;
    }
}
