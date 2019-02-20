package com.example.sensor;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sensor.adapter.ImagePagerAdapter;
import com.example.sensor.bean.GoodInfo;

import java.util.ArrayList;

public class ViewPageActivity extends AppCompatActivity  implements ViewPager.OnPageChangeListener{

    private ArrayList<GoodInfo> goodList;
    private ImagePagerAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        viewPager = findViewById(R.id.vp_content);
        goodList = GoodInfo.getGoodList();
        adapter = new ImagePagerAdapter(this,goodList);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("gsy","onPageScrolled position = "+position +",good ="+goodList.get(position).name);
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("gsy","onPageSelected position = "+position +",good ="+goodList.get(position).name);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d("gsy","onPageScrollStateChanged state ="+state);
    }
}
