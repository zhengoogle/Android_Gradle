package com.simple.fwlibrary.base.comp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Activity base class
 */
public abstract class FwCompActivity extends AppCompatActivity {
    public Context mContext;
    public static boolean isKeepActionBar = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isKeepActionBar){  // set no title
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if(getMainView() != 0) {    // set layout
            setContentView(getMainView());
        }
        mContext = this;
        initDatas();
        initViews();
        initEvents();
        loadDatas();
    }

    public abstract int getMainView();
    public abstract void initDatas();
    public abstract void initViews();
    public abstract void initEvents();
    public abstract void loadDatas();
}
