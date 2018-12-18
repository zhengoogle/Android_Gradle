package com.simple.jacocolibrary.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.simple.jacocolibrary.R;

public class MainActivity extends AppCompatActivity {

    TextView amTvElm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amTvElm = (TextView)findViewById(R.id.am_tv_elm);
        amTvElm.setText("123");
    }
}
