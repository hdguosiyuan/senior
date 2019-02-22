package com.example.sensor;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.sensor.fragment.StaticFragment;

import java.lang.reflect.Method;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String a = System.getProperty("ro.hsm.asset.num", "0");
        calendar = Calendar.getInstance();
    }

    public String getSystemProperty(String name, String defaultValue) {
        @SuppressWarnings("rawtypes")
        Class SystemProperties;
        try {
            SystemProperties = Class.forName("android.os.SystemProperties");

            // Parameters Types
            @SuppressWarnings("rawtypes")
            Class[] paramTypes = new Class[2];
            paramTypes[0] = String.class;
            paramTypes[1] = String.class;

            @SuppressWarnings("unchecked")
            Method get = SystemProperties.getMethod("get", paramTypes);

            // Parameters
            Object[] params = new Object[2];
            params[0] = name;
            params[1] = defaultValue;

            return (String) get.invoke(SystemProperties, params);
        } catch (Exception e) {
            Log.d("gsy", "e= " + e);
            return null;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.data_pick:
                showDataPick();
                break;
            case R.id.time_pick:
                showTimePick();
                break;
            case R.id.base_adapter:
                Log.d("wlw", "onClick");
                this.startActivity(new Intent(this, ListViewActivity.class));
                break;
            case R.id.grid_view:
                startActivity(new Intent(this, GridViewActivity.class));
                break;
            case R.id.viewpage:
                startActivity(new Intent(this, ViewPageActivity.class));
                break;
            case R.id.bt_tab:
                startActivity(new Intent(this, PageTabStripActivity.class));
                break;
            case R.id.vp_launch:
                startActivity(new Intent(this, LaunchSimpleActivity.class));
                break;
            case R.id.static_fragment:
                startActivity(new Intent(this, FragmentStaticActivity.class));
                break;
            case R.id.dynamic_fragment:
                startActivity(new Intent(this, FragmentDynamicActivity.class));
                break;
            default:
                break;
        }
    }

    private void showDataPick() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void showTimePick() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Log.d("gsy", "onDateSet =" + year + "," + month + "," + dayOfMonth);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.d("gsy", "TimePicker =" + hourOfDay + "," + minute);
    }
}
