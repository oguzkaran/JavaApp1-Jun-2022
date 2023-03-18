package org.csystem.util.numeric;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilCountDigitsTest {
    @Test
    public void givenNonNegativeValue_whenCountDigits_thenReturnCount()
    {
        int actual = NumberUtil.countDigits(123);
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void givenNegativeValue_whenCountDigits_thenReturnCount()
    {
        int actual = NumberUtil.countDigits(-123);
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void givenZeroValue_whenCountDigits_thenReturnOne()
    {
        int actual = NumberUtil.countDigits(0);
        int expected = 1;

        assertEquals(expected, actual);
    }
}
