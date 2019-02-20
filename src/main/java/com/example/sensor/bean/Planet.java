package com.example.sensor.bean;

import android.content.Context;

import com.example.sensor.R;

import java.util.ArrayList;

public class Planet {

    public int image;
    public String name;
    public String desc;

    public Planet(int image,String name,String desc){
        this.image=image;
        this.name=name;
        this.desc=desc;
    }

    private static final int[] iconArray = {R.drawable.diqiu, R.drawable.tuxing, R.drawable.huoxing, R.drawable.jinxing,
            R.drawable.muxing, R.drawable.shuixing};
    private static final int[] nameArray = {R.string.earth, R.string.tuxing, R.string.huoxing, R.string.jinxing, R.string.muxing,
            R.string.shuixing};
    private static final int[] descArray={R.string.earth_desc,R.string.tuxing_desc,R.string.huoxing_desc,R.string.jinxing_desc,
    R.string.muxing_desc,R.string.shuixing_desc};

    public static ArrayList<Planet> getDefaultList(Context context){
        ArrayList<Planet> planetList = new ArrayList<Planet>();
        for(int i=0;i<iconArray.length;i++){
            planetList.add(new Planet(iconArray[i],context.getString(nameArray[i]),context.getString(descArray[i])));
        }
        return planetList;
    }

}
