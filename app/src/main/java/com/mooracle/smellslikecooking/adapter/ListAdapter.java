package com.mooracle.smellslikecooking.adapter;

import com.mooracle.smellslikecooking.R;
import com.mooracle.smellslikecooking.fragment.ListFragment;

public class ListAdapter extends RecyclerAdapter {
    //instantiate the OnSelectedRecipeInterface to be used as listener:
    private final ListFragment.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        //set the action onClick
        mListener.onListRecipeSelected(index);
    }

}
