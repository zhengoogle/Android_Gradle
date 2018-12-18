package com.simple.jacocolibrary.android.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.easymock.PowerMock.createMock;

@RunWith(PowerMockRunner.class)
public class PowerMockClazzTest {

    private PowerMockClazz powerMockClazz;

    @Test
    public void powerMockClazzTest() {
        powerMockClazz = createMock(PowerMockClazz.class);
        // private filed
        // https://www.jianshu.com/p/9161c051f48e
        Whitebox.setInternalState(powerMockClazz,"priStr","AAA");
        Object priStr = Whitebox.getInternalState(powerMockClazz, "priStr");
        assertThat("AAA".equals(priStr));
    }
}
