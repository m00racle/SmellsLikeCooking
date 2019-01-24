package com.mooracle.smellslikecooking.logging;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**This class is used to log any activity cycles within the whole app process.
 * This class only intended for testing purposes.
 * To use it just extends the MainActivity class to this class since this class already extends AppCompatActivity
 * thus it will also serves as extension for the MainActivity to AppCompatActivity*/

public class LoggingActivity extends AppCompatActivity {
    //: set the tag for these logs:
    public static final String TAG = LoggingActivity.class.getSimpleName();

    //: override the onCreate to add logging:
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate - pre");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate - post");
    }

    //: override the onStart to add logging:
    @Override
    protected void onStart() {
        Log.d(TAG, "onStart - pre");
        super.onStart();
        Log.d(TAG, "onStart - post");
    }

    //: override the onResume to add logging:
    @Override
    protected void onResume() {
        Log.d(TAG, "onResume - pre");
        super.onResume();
        Log.d(TAG, "onResume - post");
    }

    //: override the onPause to add logging:
    @Override
    protected void onPause() {
        Log.d(TAG, "onPause - pre");
        super.onPause();
        Log.d(TAG, "onPause - post");
    }

    //: override the onStop to add logging:
    @Override
    protected void onStop() {
        Log.d(TAG, "onStop - pre");
        super.onStop();
        Log.d(TAG, "onStop - post");
    }

    //: override the onDestroy to add logging:
    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy - pre");
        super.onDestroy();
        Log.d(TAG, "onDestroy - post");
    }
}
