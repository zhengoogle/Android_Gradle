package com.simple.fwlibrary.base;

import android.app.Application;

/**
 * Created by x5670 on 2018/1/4.
 * FwApp
 */

public class FwApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        FwInit.initFw(this);
    }
}
