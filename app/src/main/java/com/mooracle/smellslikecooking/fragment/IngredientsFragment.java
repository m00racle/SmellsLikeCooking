package com.mooracle.smellslikecooking.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.mooracle.smellslikecooking.R;
import com.mooracle.smellslikecooking.model.Recipes;

import java.util.Objects;

public class IngredientsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //: retrieve the index from the bundle attached as argument from ViewPagerFragment:
        int index = getArguments() != null ? getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX) : 0;

        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        //: get an array of ingredients using get array and separated using regex " ' ":
        String[] ingredients = Recipes.ingredients[index].split("`");

        //: reference the linear layout in the ingredients_fragment xml:
        LinearLayout linearLayout = view.findViewById(R.id.ingredientLayout);

        //: loop through all ingredients and make checkboxes from each of ingredient:
        setUpCheckBoxes(ingredients, linearLayout);
        return view;
    }

    private void setUpCheckBoxes(String[] ingredients, @Nullable ViewGroup container) {
        for (String ingredient : ingredients){
            CheckBox checkBox = new CheckBox(getActivity());

            //: set some properties of the checkbox:
            checkBox.setPadding(8, 16, 8, 16);
            checkBox.setTextSize(20);
            checkBox.setText(ingredient);

            Objects.requireNonNull(container).addView(checkBox);
        }
    }
}
