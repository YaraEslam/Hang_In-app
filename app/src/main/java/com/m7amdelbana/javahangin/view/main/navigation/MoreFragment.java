package com.m7amdelbana.javahangin.view.main.navigation;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m7amdelbana.javahangin.R;

public class MoreFragment extends Fragment {

    public MoreFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more, container, false);
    }
}
