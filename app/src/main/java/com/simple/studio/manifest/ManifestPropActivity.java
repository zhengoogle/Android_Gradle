package com.simple.studio.manifest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.simple.fwlibrary.vutils.FwLog;
import com.simple.studio.R;
import com.simple.fwlibrary.log.xlog.XLog;

/**
 * ManifestPropActivity
 * https://www.cnblogs.com/zhaohongtian/p/6808962.html
 */
public class ManifestPropActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manifest_prop);

        String params = "env_key: " + MetaUtils.getMetaValue(this, "env_key") + "\n";
        params += "env_key0: " + MetaUtils.getMetaValue(this, "env_key0") + "\n";
        params += "env_key1: " + MetaUtils.getMetaValue(this, "env_key1") + "\n";
        XLog.i(params);
        FwLog.i(MetaUtils.getMetaValue(this, "env_key1"));
    }
}
