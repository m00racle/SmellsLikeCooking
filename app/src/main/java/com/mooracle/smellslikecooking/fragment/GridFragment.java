package com.mooracle.smellslikecooking.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mooracle.smellslikecooking.R;
import com.mooracle.smellslikecooking.adapter.GridAdapter;
import com.mooracle.smellslikecooking.adapter.ListAdapter;
import com.mooracle.smellslikecooking.logging.LoggingFragment;

public class GridFragment extends Fragment {
    //: set tag for this ListFragment
    public static final String GRID_FRAGMENT ="List_Fragment";

    //: create an interface to process when a recipe is selected:
    public interface OnRecipeSelectedInterface {
        //: create method to process when a recipe in the list is selected
        //since this is an interface we just need to make abstract method
        void onGridRecipeSelected(int index);
    }

    //override onCreateView method
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //: create log for fragment's onCreateView:
        Log.d(LoggingFragment.TAG, "onCreateView");

        //: create new OnRecipeSelectedInterface object:
        GridFragment.OnRecipeSelectedInterface listener = (GridFragment.OnRecipeSelectedInterface) getActivity();

        View view = inflater.inflate(R.layout.fragment_item, container, false);

        //add the recycler view layout
        RecyclerView recyclerView = view.findViewById(R.id.fragmentRecyclerView);

        //add the Grid Adapter object

        GridAdapter gridAdapter = new GridAdapter(listener);

        //set the List Adapter to recycler view:
        recyclerView.setAdapter(gridAdapter);

        //set the layout manager

        //set the DisplayMetrics to retrieve the Display size:
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        //calculate the displayWidth in dp since width unit is in pixel we need to divide it by density (pixel/dp)
        float displayWidth = displayMetrics.widthPixels/displayMetrics.density;

        //the number of columns is displayWidth divided by the grid size in layout grid_item which is 200
        int numColumns = (int) (displayWidth/200);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), numColumns);

        //attach the layout manager to the recycler view
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
