package com.example.sensor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.sensor.adapter.PlanetGridAdapter;
import com.example.sensor.bean.Planet;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;
    private PlanetGridAdapter planetGridAdapter;
    private ArrayList<Planet> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = findViewById(R.id.gv_planet);
        arrayList = Planet.getDefaultList(this);
        planetGridAdapter = new PlanetGridAdapter(this,arrayList);
        gridView.setAdapter(planetGridAdapter);
    }

}
