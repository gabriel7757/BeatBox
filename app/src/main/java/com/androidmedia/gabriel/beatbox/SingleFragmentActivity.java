package com.androidmedia.gabriel.beatbox;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Gabriel on 1/7/2017.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();
    private static final String CUSTOMIZE_TAG = "CustomizeTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());



        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if(fragment == null) {

            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();

        }
    }



    @LayoutRes
    protected int getLayoutResId(){

        return R.layout.activity_fragment;

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(CUSTOMIZE_TAG, "+ ON RESUME +");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(CUSTOMIZE_TAG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(CUSTOMIZE_TAG, "-- ON STOP --");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(CUSTOMIZE_TAG, "- ON DESTROY -");
    }






}
