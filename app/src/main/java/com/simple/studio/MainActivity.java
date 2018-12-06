package com.simple.studio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.simple.fwlibrary.vutils.FwJumpUtils;
import com.simple.studio.manifest.ManifestPropActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FwJumpUtils.jumpToTarget(this, ManifestPropActivity.class);
    }
}
