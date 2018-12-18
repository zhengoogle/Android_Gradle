package com.simple.jacocolibrary.android;

import android.app.Activity;
import android.content.Context;
import android.test.mock.MockContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.easymock.PowerMock.createMock;

/**
 * PowerMock
 * https://github.com/powermock/powermock
 */
//@RunWith(PowerMockRunner.class)
public class MainActivityTest {
    private Context mContext;
    private Activity mockActivity;

    @Before
    public void setUp() {
        mockActivity = createMock(Activity.class);
        mContext = new MockContext();
    }

    @Test
    public void startTest() {
        //        Assert.assertEquals();
        assertThat(mockActivity).isNotNull();
        FwSPUtils.put(mContext,"key01","value01");
        String key01 = (String)FwSPUtils.get(mContext, "key01", "");
        assertThat(key01).isEqualTo("value01");
    }
}
