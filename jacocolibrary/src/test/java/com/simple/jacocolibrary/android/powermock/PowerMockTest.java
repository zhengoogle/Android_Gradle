package com.simple.jacocolibrary.android.powermock;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.test.mock.MockContext;

import com.simple.jacocolibrary.android.FwSPUtils;
import com.simple.jacocolibrary.android.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.powermock.api.easymock.PowerMock.createMock;

/**
 * PowerMock
 * dependencies easymock
 * ---https://github.com/powermock/powermock
 * exam:
 * ---https://www.programcreek.com/java-api-examples/?api=android.test.mock.MockContext
 *
 * blog:
 * ---https://www.jianshu.com/p/d214b48792d0
 *
 * Junit+Mockito+PowerMock
 * ---环境构造完整性：仅提供基础实例
 * ---对象构造能力：mock的对象不具备完整属性
 * ---方法测试能力：完整测试特性
 *
 * android.test.mock.MockContext
 * 构造测试对象例子
 * ---https://www.programcreek.com/java-api-examples/?api=android.test.mock.MockContext
 */
@RunWith(PowerMockRunner.class)
public class PowerMockTest {
    private Context mContext;
    private Activity powerMockActivity;
    private Activity mockActivity;
    private MainActivity mainActivity;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Before
    public void prepareContext() {
        mContext = new MockContext();
        powerMockActivity = createMock(Activity.class);
        mainActivity = createMock(MainActivity.class);
        mockActivity = mock(Activity.class);
        sharedPreferences = mock(SharedPreferences.class);
        editor = mock(SharedPreferences.Editor.class);
    }

    @Test
    public void testActivityNotNull() {
//        mainActivity.onCreate(mock(Bundle.class));
        assertThat(mockActivity).isNotNull();
        FwSPUtils.sharedPreferences = sharedPreferences;
        FwSPUtils.spEditor = editor;
        new FwSPUtils().setContext(mContext);
        FwSPUtils.put(mockActivity,"key01","value01");
        String key01 = (String)FwSPUtils.get(powerMockActivity, "key01", "");
        assertThat("value01").isEqualTo(key01);

        MainActivity mainActivity = PowerMockito.mock(MainActivity.class);
        try {
            PowerMockito.when(mainActivity, "onCreate",mock(Bundle.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
