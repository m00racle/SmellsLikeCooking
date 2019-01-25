package com.mooracle.smellslikecooking.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mooracle.smellslikecooking.R;

public class ViewPagerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //: add a View object named view with layout in use fragment_viewpager, with no attach to root
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        return view;
    }
}
