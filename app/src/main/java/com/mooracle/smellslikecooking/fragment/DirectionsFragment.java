package com.mooracle.smellslikecooking.fragment;

import com.mooracle.smellslikecooking.model.Recipes;

public class DirectionsFragment extends CheckboxesFragment {
    @Override
    public String[] getContent(int index) {
        return Recipes.directions[index].split("`");
    }
}
