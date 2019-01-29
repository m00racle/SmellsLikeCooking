package com.mooracle.smellslikecooking.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mooracle.smellslikecooking.R;
import com.mooracle.smellslikecooking.model.Recipes;

import java.util.Objects;

/**
 * this class manage the fragment_dual pane.xml layout
 * */
public class DualPaneFragment extends Fragment {
    //: make String constant name to store the index name:
    public static final String KEY_RECIPE_INDEX = "recipe_index";
    public static final String DUALPANE_FRAGMENT = "DualPane_fragment";
    private static final String INGREDIENT_FRAGMENT = "ingredients_fragment";
    private static final String DIRECTIONS_FRAGMENT = "directions_fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dualpane, container, false);

        //get the index
        int index = getArguments() != null ? getArguments().getInt(KEY_RECIPE_INDEX) : 0;

        // : check if there already fragment in place:
        FragmentManager fragmentManager = getChildFragmentManager();
        IngredientsFragment savedIngredientsFragment =
                (IngredientsFragment) fragmentManager.findFragmentByTag(INGREDIENT_FRAGMENT);
        if (savedIngredientsFragment == null){
            //set the ingredient fragment :
            IngredientsFragment ingredientsFragment = new IngredientsFragment();
            DirectionsFragment directionsFragment = new DirectionsFragment();

            //set the index for ingredients and directions fragments:
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_RECIPE_INDEX, index);

            ingredientsFragment.setArguments(bundle);

            //begin transaction:
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.leftPlaceholder, ingredientsFragment, INGREDIENT_FRAGMENT);

            transaction.commit();
        }

        //: check if the direction fragment is already in saved instance:
        DirectionsFragment savedDirectionFragment =
                (DirectionsFragment) fragmentManager.findFragmentByTag(DIRECTIONS_FRAGMENT);
        if (savedDirectionFragment == null){
            //set DirectionFragment
            DirectionsFragment directionsFragment = new DirectionsFragment();

            //set the index for ingredients and directions fragments:
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_RECIPE_INDEX, index);

            directionsFragment.setArguments(bundle);

            //begin transaction:
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.add(R.id.rightPlaceholder, directionsFragment, DIRECTIONS_FRAGMENT);
            transaction.commit();
        }

        //  :set the title action bar as the recipe name:
        //  NOTE: this must be set outside the if statement since when device rotated it will stop and the old fragment
        //  will not retain the recipe's name as title anymore and back to app name
        Objects.requireNonNull(getActivity()).setTitle(Recipes.names[index]);

        return view;
    }

    //: use onStop override method to make the action bar title back to app name:

    @Override
    public void onStop() {
        super.onStop();
        Objects.requireNonNull(getActivity()).setTitle(getResources().getString(R.string.app_name));
    }
}
