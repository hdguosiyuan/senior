package com.example.sensor;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sensor.adapter.PlanetListAdapter;
import com.example.sensor.bean.Planet;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private PlanetListAdapter planetListAdapter;
    private ArrayList<Planet> planetArrayList;
    private ListView listView;
    private Spinner spinner;
    private Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        planetArrayList = Planet.getDefaultList(this);
        planetListAdapter = new PlanetListAdapter(this,planetArrayList);

        drawable=getDrawable(R.drawable.divider_red2);

        listView=findViewById(R.id.list_planet);
        listView.setAdapter(planetListAdapter);
        listView.setOnItemClickListener(planetListAdapter);

        spinner = findViewById(R.id.sp_list);
        initView();
    }

    private void initView(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item,dividerArray);
        spinner.setOnItemSelectedListener(new DividerSelectListener());
        spinner.setAdapter(arrayAdapter);
    }

    private String[] dividerArray={
            "不显示分隔线(分隔线高度为0)",
            "不显示分隔线(分隔线为null)",
            "只显示内部分隔线(先设置分隔线高度)",
            "只显示内部分隔线(后设置分隔线高度)",
            "显示底部分隔线(高度是wrap_content)",
            "显示底部分隔线(高度是match_parent)",
            "显示顶部分隔线(别瞎折腾了，显示不了)",
            "显示全部分隔线(看我用padding大法)"
    };

    private class DividerSelectListener implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(ListViewActivity.this, "position ="+dividerArray[position], Toast.LENGTH_SHORT).show();
            int dividerHeight = 5;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            listView.setDivider(drawable);
            listView.setPadding(0,0,0,0);
            listView.setDividerHeight(dividerHeight);
            listView.setBackgroundColor(Color.TRANSPARENT);
            switch(position){
                case 0:
                    listView.setDividerHeight(0);
                    break;
                case 1:
                    listView.setDivider(null);
                    listView.setDividerHeight(dividerHeight);
                    break;
                    case 2:
                    listView.setDividerHeight(dividerHeight);
                    listView.setDivider(drawable);
                    break;
                case 3:
                    listView.setDivider(drawable);
                    listView.setDividerHeight(dividerHeight);
                    break;
                case 4:
                    listView.setFooterDividersEnabled(true);
                    break;
                case 5:
                    params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,1);
                    listView.setFooterDividersEnabled(true);
                    break;
                case 6:
                    break;
                case 7:
                    listView.setDivider(null);
                    listView.setDividerHeight(dividerHeight);
                    listView.setPadding(0,dividerHeight,0,dividerHeight);
                    listView.setBackgroundDrawable(drawable);
            }
            listView.setLayoutParams(params);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(ListViewActivity.this,"nothing select",Toast.LENGTH_LONG).show();
        }
    }
}
