package org.csystem.util.math;

import org.csystem.util.math.exception.MathOperationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MutableFractionExceptionTest {
    @Test
    public void givenNumeratorAndDenominatorBothZero_whenConstructor_throwsMathOperationException()
    {
        int a = 0, b = 0;

        assertThrows(MathOperationException.class, () -> new MutableFraction(a, b));
    }

    @Test
    public void givenNumeratorNonZeroAndDenominatorZero_whenConstructor_throwsMathOperationException()
    {
        int a = 3, b = 0;

        assertThrows(MathOperationException.class, () -> new MutableFraction(a, b));
    }

    @Test
    public void givenNumeratorAndDenominatorBothNonZero_whenConstructor_doesNotThrowsMathOperationException()
    {
        int a = 3, b = 30;

        assertDoesNotThrow(() -> new MutableFraction(a, b));
    }

    @Test
    public void givenNumeratorAndDenominatorBothZero_whenConstructor_throwsMathOperationException_withNMathOperationStatusNAN()
    {
        int a = 0, b = 0;
        MathOperationStatus expected = MathOperationStatus.NAN;

        try {
            new MutableFraction(a, b);
        }
        catch (MathOperationException ex) {
            assertEquals(expected, ex.getMathOperationStatus());
        }
    }

    @Test
    public void givenNumeratorNonZeroAndDenominatorZero_whenConstructor_throwsMathOperationException_withNMathOperationStatusPOSITIVE_INFINITY()
    {
        int a = 10, b = 0;
        MathOperationStatus expected = MathOperationStatus.POSITIVE_INFINITY;

        try {
            new MutableFraction(a, b);
        }
        catch (MathOperationException ex) {
            assertEquals(expected, ex.getMathOperationStatus());
        }
    }

    @Test
    public void givenNumeratorNonZeroAndDenominatorZero_whenConstructor_throwsMathOperationException_withNMathOperationStatusNEGATIVE_INFINITY()
    {
        int a = -10, b = 0;
        MathOperationStatus expected = MathOperationStatus.NEGATIVE_INFINITY;

        try {
            new MutableFraction(a, b);
        }
        catch (MathOperationException ex) {
            assertEquals(expected, ex.getMathOperationStatus());
        }
    }
}
