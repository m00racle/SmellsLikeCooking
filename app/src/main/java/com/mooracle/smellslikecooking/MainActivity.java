package com.mooracle.smellslikecooking;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.mooracle.smellslikecooking.fragment.DualPaneFragment;
import com.mooracle.smellslikecooking.fragment.GridFragment;
import com.mooracle.smellslikecooking.fragment.ListFragment;
import com.mooracle.smellslikecooking.fragment.ViewPagerFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface,
        GridFragment.OnRecipeSelectedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //: get the boolean value from the is_tablet variable:
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        //Toast.makeText(this, isTablet + "", Toast.LENGTH_SHORT).show();

        // if the device is not a tablet then use the ListFragment, else use GridFragment:
        if (!isTablet){
            //: create a new field of listFragment as basis for if checking: (Remember to cast it to ListFragment)
            //: use Tag from ListFragment to find the Fragment.
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager()
                    .findFragmentByTag(ListFragment.LIST_FRAGMENT);

            //: if the savedFragment is null then only add new fragment:
            if (savedFragment == null){
                // crete the list fragment object:
                ListFragment fragment = new ListFragment();

                // create fragment manager to add our fragment into place holder:
                //this is the latest app support fragment manager since the old getFragmentManager method has beed deprecated
                FragmentManager fragmentManager = getSupportFragmentManager();

                // create the fragment transaction variable:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                //: use tag to find ListFragment:
                fragmentTransaction.add(R.id.placeHolder, fragment, ListFragment.LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        } else {
            // create the gridFragment:
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager()
                    .findFragmentByTag(GridFragment.GRID_FRAGMENT);

            //check if the savedFragment is null or not:
            if (savedFragment == null){
                //create the Grid Fragment (new):
                GridFragment fragment = new GridFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // use the transaction to add Grid fragment and give it a tag
                fragmentTransaction.add(R.id.placeHolder, fragment, GridFragment.GRID_FRAGMENT);
                fragmentTransaction.commit();
            }
        }



    }

    @Override
    public void onListRecipeSelected(int index) {

        //: replace the current ListFragment with ViewPagerFragment
        ViewPagerFragment fragment = new ViewPagerFragment();

        // : add bundle to store int index for the chosen recipe:
        Bundle bundle = new Bundle();

        //: add the index into the bundle
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);

        //: set the bundle as argument for our newly created ViewPagerFragment:
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //set the animation transition for the ViewPager fragment
        transaction.setCustomAnimations(R.animator.slide_down_enter,R.animator.slide_down_exit);

        //: use tag to find the viewPagerFragment instead placeholder id
        transaction.replace(R.id.placeHolder, fragment, ViewPagerFragment.VIEWPAGER_FRAGMENT);

        //: add transaction to backstack
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {
        //: initialize the DualPaneFragment:
        DualPaneFragment fragment = new DualPaneFragment();

        //give the index into bundle and sent it to DualPanelFragment:
        Bundle bundle = new Bundle();

        bundle.putInt(DualPaneFragment.KEY_RECIPE_INDEX, index);

        fragment.setArguments(bundle);

        //: begin the transaction of the fragments:
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.placeHolder, fragment, DualPaneFragment.DUALPANE_FRAGMENT);

        //add to backstack:
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
