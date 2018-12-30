package com.simple.jacocolibrary.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.simple.jacocolibrary.R;

public class AppTestActivity extends AppCompatActivity {

    private TextView amTvElm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_test);

        amTvElm = (TextView)findViewById(R.id.am_tv_elm);
        amTvElm.setText("123");
    }
}
