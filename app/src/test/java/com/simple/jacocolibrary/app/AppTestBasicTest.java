package com.simple.jacocolibrary.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Java test
 */
public class AppTestBasicTest {
    @Test
    public void addition_isCorrect() {
        assertEquals((new AppTestBasic()).getSum(1, 1), 2);
    }
}
