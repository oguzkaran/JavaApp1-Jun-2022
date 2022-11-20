package tr.com.cankartal.calculator;

import org.csystem.app.calculator.IIntBinaryOperation;

public class MultiplyOperation implements IIntBinaryOperation {
    @Override
    public boolean isValid(char ch)
    {
        return ch == '*';
    }

    @Override
    public int applyAsInt(int left, int right)
    {
        return 3 * (left * right);
    }
}
