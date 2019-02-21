package com.example.sensor;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sensor.adapter.LaunchSimpleAdapter;

public class LaunchSimpleActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private int[] imageArray = {R.drawable.guide_bg1, R.drawable.guide_bg2, R.drawable.guide_bg3, R.drawable.guide_bg4};
    private LaunchSimpleAdapter launchSimpleAdapter;
    private Button startButton;

    public LaunchSimpleActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_simple);

        viewPager = findViewById(R.id.vp_launch);
        radioGroup = findViewById(R.id.rg_radiogroup);
        launchSimpleAdapter = new LaunchSimpleAdapter(this,imageArray);

        for (int i =0;i<imageArray.length;i++){
            RadioButton radioButton = new RadioButton(this);
            radioButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            radioButton.setPadding(10,10,10,10);
            radioButton.setButtonDrawable(R.drawable.launch_guide);
            radioGroup.addView(radioButton,i);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                viewPager.setCurrentItem(checkedId -1);
                Log.d("gsy","checkedId ="+checkedId);
            }
        });

        View view = LayoutInflater.from(this).inflate(R.layout.item_launch,null);
        startButton = view.findViewById(R.id.bt_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("gsy","start button click");
                Toast.makeText(getApplicationContext(),"start",Toast.LENGTH_LONG).show();
            }
        });

        viewPager.setAdapter(launchSimpleAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
        ((RadioButton)radioGroup.getChildAt(0)).setChecked(true);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        if(position == 3){
            Log.d("gsy","setVisibility visible");
            startButton.setVisibility(View.VISIBLE);
        }
        ((RadioButton)radioGroup.getChildAt(position)).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
