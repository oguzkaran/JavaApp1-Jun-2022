package org.csystem.coding;

import java.util.Stack;

public final class CodingChallenge {
    private CodingChallenge()
    {
    }

    public static boolean areCurlyBracesMatch(String s)
    {
        var stack = new Stack<Character>();

        int len = s.length();

        for (int i = 0; i < len; ++i) {
            switch (s.charAt(i)) {
                case '{' -> stack.push('{');
                case '}' -> {if (stack.empty()) return false; stack.pop();}
                //default -> {return false;}
            }
        }

        return stack.empty();
    }

    public static String reverseWithStack(String s)
    {
        var stack = new Stack<Character>();
        var chars = s.toCharArray();
        for (char ch : chars)
            stack.push(ch);

        int i = 0;

        while (!stack.empty())
            chars[i++] = stack.pop();

        return String.valueOf(chars);
    }
}
