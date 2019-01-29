package com.mooracle.smellslikecooking.adapter;

import com.mooracle.smellslikecooking.R;
import com.mooracle.smellslikecooking.fragment.GridFragment;

public class GridAdapter extends RecyclerAdapter{
    //field to fill the OnRecipeSelectedInterface of GridFragment
    private final GridFragment.OnRecipeSelectedInterface listener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        this.listener = listener;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        listener.onGridRecipeSelected(index);
    }
}
