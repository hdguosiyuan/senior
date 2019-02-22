package com.example.sensor;

import android.graphics.Color;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sensor.adapter.MobilePagerAdapter;
import com.example.sensor.bean.GoodInfo;

import java.util.ArrayList;

public class FragmentDynamicActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    private ArrayList<GoodInfo> arrayList = GoodInfo.getGoodList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);

        viewPager = findViewById(R.id.vp_content);
        pagerTabStrip = findViewById(R.id.pts_content);

        viewPager.setAdapter(new MobilePagerAdapter(getSupportFragmentManager(), arrayList));
        pagerTabStrip.setTextSize(2, 10);
        pagerTabStrip.setTextColor(Color.GREEN);

    }
}
