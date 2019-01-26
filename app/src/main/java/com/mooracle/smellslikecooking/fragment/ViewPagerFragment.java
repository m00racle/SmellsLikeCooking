package com.mooracle.smellslikecooking.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mooracle.smellslikecooking.R;
import com.mooracle.smellslikecooking.model.Recipes;

public class ViewPagerFragment extends Fragment {
    //: set tag for ViewPagerFragment:
    public static final String VIEWPAGER_FRAGMENT = "Viewpager_Fragment";

    //: make String constant name to store the index name:
    public static final String KEY_RECIPE_INDEX = "recipe_index";
    private int index;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //: add a View object named view with layout in use fragment_viewpager, with no attach to root
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        //: get the int index value from the bundle
        index = getArguments().getInt(KEY_RECIPE_INDEX);

        //: add Toast from main activity to this fragment:
        //Toast.makeText(getActivity(), Recipes.names[index], Toast.LENGTH_SHORT).show();
        //: this toast will be changed by changing the action bar title into the recipe name
        getActivity().setTitle(Recipes.names[index]);
        return view;
    }

    @Override
    public void onStop() {
        //: when this fragment ends we need to return the action bar title back to app default (app name)
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
