/*----------------------------------------------------------------------
	FILE        : CommandLineArgsUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 13.08.2021

	Utility class for command line arguments

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/

package org.csystem.util.console.commandline;

public final class CommandLineArgsUtil {
    private CommandLineArgsUtil()
    {
    }

    public static void checkLengthEquals(String [] args, int count, String message)
    {
        checkLengthEquals(args.length, count, message, 1);
    }

    public static void checkLengthEquals(String [] args, int count, String message, int exitCode)
    {
        checkLengthEquals(args.length, count, message, exitCode);
    }

    public static void checkLengthEquals(int length, int count, String message)
    {
        checkLengthEquals(length, count, message, 1);
    }

    public static void checkLengthEquals(int length, int count, String message, int exitCode)
    {
        if (length != count) {
            System.err.println(message);
            System.exit(exitCode);
        }
    }

    public static void checkLengthGreater(int length, int count, String message, int exitCode)
    {
        if (length > count) {
            System.err.println(message);
            System.exit(exitCode);
        }
    }

    public static void checkLengthLess(int length, int count, String message, int exitCode)
    {
        if (length < count) {
            System.err.println(message);
            System.exit(exitCode);
        }
    }

    //...
}
