package com.example.sensor.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sensor.R;
import com.example.sensor.bean.GoodInfo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicFragment extends Fragment {

    public static DynamicFragment newInstance(int position, ArrayList<GoodInfo> arrayList) {
        Bundle args = new Bundle();
        DynamicFragment fragment = new DynamicFragment();
        args.putInt("image", arrayList.get(position).pic);
        args.putString("desc", arrayList.get(position).desc);
        fragment.setArguments(args);
        return fragment;
    }

    public DynamicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        ImageView imageView = view.findViewById(R.id.iv_goods);
        TextView textView = view.findViewById(R.id.tv_goods);
        Bundle bundle = getArguments();
        if (bundle != null) {
            imageView.setImageResource(bundle.getInt("image"));
            textView.setText(bundle.getString("desc"));
        }
        return view;
    }

}
