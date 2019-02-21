package com.example.sensor;

import android.graphics.Color;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sensor.adapter.ImagePagerAdapter;
import com.example.sensor.bean.GoodInfo;

import java.util.ArrayList;

public class PageTabStripActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ArrayList<GoodInfo> mGoodList;
    private ImagePagerAdapter imagePagerAdapter;
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_tab_strip);

        viewPager = findViewById(R.id.vp_good);
        pagerTabStrip = findViewById(R.id.tb_good);
        mGoodList = GoodInfo.getGoodList();
        imagePagerAdapter=new ImagePagerAdapter(this,mGoodList);

        viewPager.setAdapter(imagePagerAdapter);
        viewPager.addOnPageChangeListener(this);

        pagerTabStrip.setBackgroundColor(Color.BLUE);
        pagerTabStrip.getSolidColor();
        pagerTabStrip.setTextColor(Color.GREEN);
        pagerTabStrip.setTextSize(2,20);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this,mGoodList.get(position).name,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
