package com.simple.studio.test.android;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AndroidTestBasicTest {
    @Test
    public void addition_isCorrect() {
        assertEquals((new AndroidTestBasic()).getSum(1, 1), 2);
    }
}
