package com.mooracle.smellslikecooking;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**This class is used to represent the fragment_list layout.
 * Since this is a Fragment this class must extends Fragment class*/
public class ListFragment extends Fragment {
    //override onCreateView method

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container);
        return view;
    }
}
