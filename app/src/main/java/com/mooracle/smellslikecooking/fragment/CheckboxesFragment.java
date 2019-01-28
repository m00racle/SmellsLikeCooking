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

import java.util.Objects;

public abstract class CheckboxesFragment extends Fragment {

    private static final String KEY_CHECKED_CONTENTS = "key_checked_contents";
    private CheckBox[] checkBoxes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //: retrieve index Argument from the ViewPagerFragment:
        int index = getArguments() != null ? getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX) : 0;

        View view = inflater.inflate(R.layout.fragment_checkboxes, container, false);

        //: get the String array of contents from the model Recipe class:
        //  then use regex to separate the String into String array
        String[] contents = getContent(index);

        //: initialize checkboxes related to the size of the contents String array length:
        //  then extract the variable to be field so can be accessed around the whole class
        checkBoxes = new CheckBox[contents.length];

        //: check if the checkboxes are indeed checked by checking the savedInstanceState Bundle
        //  only if the savedInstanceState is not null and has boolean array data called key_checked_directions
        //  else the checkedBoxes will still instantiated but by default all value will be all false
        boolean[] checkedBoxes = new boolean[checkBoxes.length];
        if (savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKED_CONTENTS) != null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_CONTENTS);
        }

        //: with all set for creating checkBoxes for all contents steps we can set it into our chosen layout:
        LinearLayout linearLayout = view.findViewById(R.id.linearLayout);

        //: loop through all contents steps and set it onto the checkboxes then set the toggle if checked or not:
        setUpDirectionCheckBox(contents, checkedBoxes, linearLayout);

        return view;
    }

    public abstract String[] getContent(int index);

    private void setUpDirectionCheckBox(String[] contents, boolean[] checkedDirections, @Nullable ViewGroup container) {
        int i = 0;

        for (String content : contents){
            checkBoxes[i] = new CheckBox(getActivity());

            //: set some properties on the checkboxes:
            checkBoxes[i].setPadding(8, 16, 8, 16);
            checkBoxes[i].setTextSize(20);
            checkBoxes[i].setText(content);

            //: add the checkboxes into layout container and check if any checkboxes is checked:
            Objects.requireNonNull(container).addView(checkBoxes[i]);
            if (checkedDirections[i]){checkBoxes[i].toggle();}

            //: increment the i index:
            i++;
        }
    }

    //: override the onSaveInstanceState methdd to save the last state of each checkbox:

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        // prepare the boolean array which consist of state data of each checkbox:
        boolean[] stateOfCheckBoxes = new boolean[checkBoxes.length];

        //: loop for each checkbox to record the state of each:
        int i = 0;
        for (CheckBox checkBox : checkBoxes){
            stateOfCheckBoxes[i] = checkBox.isChecked();
            i++;
        }

        //: put the boolean array data into bundle object called outState:
        outState.putBooleanArray(KEY_CHECKED_CONTENTS, stateOfCheckBoxes);

        super.onSaveInstanceState(outState);
    }
}
