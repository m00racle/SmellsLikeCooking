package com.mooracle.smellslikecooking.fragment;

import com.mooracle.smellslikecooking.model.Recipes;

public class IngredientsFragment extends CheckboxesFragment {

    @Override
    public String[] getContent(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
