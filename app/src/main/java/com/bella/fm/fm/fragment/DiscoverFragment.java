package com.bella.fm.fm.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bella.fm.R;

/**
 * 发现
 */
public class DiscoverFragment extends Fragment {


    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false);
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e("msg","DiscoverFragment");
    }
}
