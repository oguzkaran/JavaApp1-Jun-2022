/*----------------------------------------------------------------
	FILE		: IOUtil.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 22.07.2023

	Utility class for general I/O operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IOUtil {

    private IOUtil()
    {
    }

    private static void copyAndClose(InputStream input, OutputStream output, int blockSize) throws IOException
    {
        try (input; output) {
            copy(input, output, blockSize);
        }
    }

    public static void copy(InputStream input, OutputStream output, int blockSize, boolean closeAfterCopy) throws IOException
    {
        if (closeAfterCopy)
            copyAndClose(input, output, blockSize);
        else
            copy(input, output, blockSize);
    }

    public static void copy(InputStream input, OutputStream output, int blockSize) throws IOException
    {
        byte [] data = new byte[blockSize];
        int result;

        while ((result = input.read(data)) > 0)
            output.write(data, 0, result);
    }
    //...
}
