package com.simple.jacocolibrary.android;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Robolectric
 * Android Unit Testing Framework
 * ---http://robolectric.org/
 * ---https://github.com/robolectric/robolectric
 */
//@RunWith(RobolectricTestRunner.class)
public class RobolectricTest {
    private Context mContext;

    @Test
    public void clickingButton_shouldChangeMessage() {
//        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
//
//        mContext = RuntimeEnvironment.application.getApplicationContext();
//
////        activity.button.performClick();
//
//        assertThat(activity.amTvElm.getText()).isEqualTo("Robolectric Rocks!");
    }
}
