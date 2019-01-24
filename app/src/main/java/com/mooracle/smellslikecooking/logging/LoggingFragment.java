package com.mooracle.smellslikecooking.logging;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

/**This class is intended to log any Fragment cycles happens along the app processes
 * This class in only intended for test purposes thus will be unused after it is done
 * To use this just extend this class from any Fragment class
 * This class already extends Fragmet thus the Fragment extending this class will also extended Fragment*/

public class LoggingFragment extends Fragment {
    //: set the TAG for these logs:
    public static final String TAG = LoggingFragment.class.getSimpleName();

    //: override the onAttach to add logging:
    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach");
        super.onAttach(context);
    }

    //: override the onCreate to add logging:
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    //: override the onActivityCreated to add logging:
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    //: override the onStart to add logging:
    @Override
    public void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    //: override the onResume to add logging:
    @Override
    public void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    //: override the onPause to add logging:
    @Override
    public void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    //: override the onStop to add logging:
    @Override
    public void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    //: override the onDestroyView to add logging:
    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView");
        super.onDestroyView();
    }

    //: override the onDestroy to add logging:
    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    //: override the onDetach to add logging:
    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach");
        super.onDetach();
    }
}
