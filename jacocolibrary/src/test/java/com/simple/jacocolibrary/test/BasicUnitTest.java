package com.simple.jacocolibrary.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals((new BasicUnit()).getSum(1, 1), 2);
    }
}
