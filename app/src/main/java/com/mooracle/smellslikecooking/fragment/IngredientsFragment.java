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
    private static final String KEY_CHECKED_BOXES = "key_checked_boxes";
    // add a checkboxes array to enable access of the checkboxes created from outside:
    private CheckBox[] checkBoxes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //: retrieve the index from the bundle attached as argument from ViewPagerFragment:
        int index = getArguments() != null ? getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX) : 0;

        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        //: get an array of ingredients using get array and separated using regex " ' ":
        String[] ingredients = Recipes.ingredients[index].split("`");

        //: initialize the array of checkboxes with the length the same as the ingredients array of String:
        checkBoxes = new CheckBox[ingredients.length];

        //: set an array of boolean to store each stateOfCheckboxes only if there are one in savedInstanceState:
        boolean[] checkedBoxes = new boolean[checkBoxes.length];
        if (savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES) != null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }

        //: reference the linear layout in the ingredients_fragment xml:
        LinearLayout linearLayout = view.findViewById(R.id.ingredientLayout);

        //: loop through all ingredients and make checkboxes from each of ingredient:
        setUpCheckBoxes(ingredients, linearLayout, checkedBoxes);
        return view;
    }

    private void setUpCheckBoxes(String[] ingredients, @Nullable ViewGroup container, boolean[] checkedBoxes) {
        //: set int index called i to denotes the checkbox index instead just new chcekBox object:
        int i = 0;

        for (String ingredient : ingredients){
            checkBoxes[i] = new CheckBox(getActivity());
            //: set some properties of the checkbox:
            checkBoxes[i].setPadding(8, 16, 8, 16);
            checkBoxes[i].setTextSize(20);
            checkBoxes[i].setText(ingredient);

            Objects.requireNonNull(container).addView(checkBoxes[i]);

            //: determine if the checkbox is checked or not: if it is then use toggle() to make it checked
            if (checkedBoxes[i]){checkBoxes[i].toggle();}

            //: increment the int i to the next index of checkBox in checkBoxes
            i++;
        }
    }

    //: create an override of method onSaveInstanceState to save the state of each checkbox:
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        //: make boolean variable to store each state of the checkbox:
        // NOTE: the length of this boolean array will always the same as checkBoxes array:
        boolean[] stateOfCheckBoxes = new boolean[checkBoxes.length];

        //: loop through all checkboxes to save the state of them:
        // NOTE: we use int i as index for each stateOfCheckBoxes
        int i = 0;
        for (CheckBox checkBox : checkBoxes){
            stateOfCheckBoxes[i] = checkBox.isChecked();
            i++;
        }

        //: set all stateOfCheckBoxes into a bundle called outState to be save in the super:
        outState.putBooleanArray(KEY_CHECKED_BOXES, stateOfCheckBoxes);

        super.onSaveInstanceState(outState);
    }
}
