package com.example.sensor;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sensor.fragment.StaticFragment;

public class FragmentStaticActivity extends AppCompatActivity implements StaticFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_static);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("gsy","onFragmentInteraction ="+uri);
    }
}
