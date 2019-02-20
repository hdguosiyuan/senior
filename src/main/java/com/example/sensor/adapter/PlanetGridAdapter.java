package com.example.sensor.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensor.R;
import com.example.sensor.bean.Planet;

import java.util.ArrayList;

public class PlanetGridAdapter extends BaseAdapter implements AdapterView.OnItemClickListener{

    private Context context;
    private ArrayList<Planet> arrayList;

    public PlanetGridAdapter(Context context, ArrayList<Planet> arrayList) {
        this.context = context;
        this.arrayList=arrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlanetGridAdapter.ViewHolder viewHolder ;
        if(convertView==null){
            viewHolder = new PlanetGridAdapter.ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid,null);
            viewHolder.iv_icon=convertView.findViewById(R.id.iv_planet);
            viewHolder.tv_name=convertView.findViewById(R.id.tv_name);
            viewHolder.tv_desc=convertView.findViewById(R.id.tv_desc);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (PlanetGridAdapter.ViewHolder) convertView.getTag();
        }
        Planet planet=arrayList.get(position);
        Log.d("gsy","planet.image ="+planet.image+" ,viewHolder.iv_icon ="+viewHolder.iv_icon);
        viewHolder.iv_icon.setImageResource(planet.image);
        viewHolder.tv_name.setText(planet.name);
        viewHolder.tv_desc.setText(planet.desc);
        return convertView;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context,"click "+ arrayList.get(position).name,Toast.LENGTH_LONG).show();
    }

    public final class ViewHolder{
        public ImageView iv_icon;
        public TextView tv_name;
        public TextView tv_desc;
    }
}
