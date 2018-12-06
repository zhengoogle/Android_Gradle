package com.simple.studio.manifest;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Created by x5670 on 2018/1/4.
 *  MetaUtils
 */

public class MetaUtils {
    /**
     * 获取meta属性
     * @param context
     * @param key
     * @return
     */
    public static String getMetaValue(Context context,String key){
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (applicationInfo == null){
            return "";
        }
        return applicationInfo.metaData.getString(key);
    }
}
