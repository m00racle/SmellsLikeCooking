package com.mooracle.smellslikecooking;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mooracle.smellslikecooking.logging.LoggingFragment;

/**This class is used to represent the fragment_list layout.
 * Since this is a Fragment this class must extends Fragment class*/
public class ListFragment extends LoggingFragment {
    //: create an interface to process when a recipe is selected:
    public interface OnRecipeSelectedInterface {
        //: create method to process when a recipe in the list is selected
        //since this is an interface we just need to make abstract method
        void onListRecipeSelected(int index);
    }

    //override onCreateView method
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //: create log for fragment's onCreateView:
        Log.d(LoggingFragment.TAG, "onCreateView");

        //: create new OnRecipeSelectedInterface object:
        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        //add the recycler view layout
        RecyclerView recyclerView = view.findViewById(R.id.listRecyclerView);

        //add the List Adapter object
        //ListAdapter listAdapter = new ListAdapter(listener);
        ListAdapter listAdapter = new ListAdapter(listener);

        //set the List Adapter to recycler view:
        recyclerView.setAdapter(listAdapter);

        //set the layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        //attach the layout manager to the recycler view
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
