package com.simple.fwlibrary.base.comp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.Window;

import com.simple.fwlibrary.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e2670 on 2017/10/26.
 * BasePermissionActivity
 *  先取得系统相关访问权限再进入APP
 */

public abstract class FwPermissionActivity extends Activity{
    public Context mContext;
    public static boolean isKeepActionBar = false;
    public List<TaskCallbackInf> listTask = new ArrayList<>();

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
        getPermission();
    }

    public abstract int getMainView();
    public abstract void initDatas();
    public abstract void initViews();
    public abstract void initEvents();
    public abstract void loadDatas();

    /**
     * 获取权限
     */
    public void getPermission() {
        // start request permission
        for (int i = 0; i < listTask.size(); i++) {
            listTask.get(i).onStart();
        }
        hasPermission = hasPermission();
        if (!hasPermission) {
            if (shouldShowRequestPermissionRationale()) {
                showPermissionRequestDialog(false);
            } else {
                requestPermission();
            }
        } else {
            for (int i = 0; i < listTask.size(); i++) {
                listTask.get(i).onFinished(true);
            }
            initDatas();
            initViews();
            initEvents();
            loadDatas();
        }
    }

    /**
     * xLog动态权限申请存贮权限：
     * https://github.com/elvishew/xLog
     */
    private static final int PERMISSIONS_REQUEST_EXTERNAL_STORAGE = 1;
    private boolean hasPermission;

    private boolean hasPermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED;
    }

    private boolean shouldShowRequestPermissionRationale() {
        return ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PERMISSIONS_REQUEST_EXTERNAL_STORAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                hasPermission = grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if (!hasPermission) {
                    if (shouldShowRequestPermissionRationale()) {
                        showPermissionRequestDialog(false);
                    } else {
                        showPermissionRequestDialog(true);
                    }
                }else {
                    for (int i = 0; i < listTask.size(); i++) {
                        listTask.get(i).onFinished(true);
                    }
                    initDatas();
                    initViews();
                    initEvents();
                    loadDatas();
                }
            }
        }
    }

    /**
     * Show a dialog for user to explain about the permission.
     */
    private void showPermissionRequestDialog(final boolean gotoSettings) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.permission_request)
                .setMessage(R.string.permission_explanation)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(gotoSettings ? R.string.go_to_settings : R.string.allow,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (gotoSettings) {
                                    startAppSettings();
                                } else {
                                    requestPermission();
                                }
                            }
                        })
                .show();
    }

    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }

    public interface TaskCallbackInf {
        void onStart();

        void onFinished(boolean isSuccess);
    }
}
