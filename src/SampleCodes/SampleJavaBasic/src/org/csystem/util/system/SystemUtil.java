/*----------------------------------------------------------------------
	FILE        : SystemUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 12.08.2023

	Utility class for system operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.system;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Path;

public final class SystemUtil {
    private static final String LITTLE_ENDIAN_TEXT = "LITTLE ENDIAN";
    private static final String BIG_ENDIAN_TEXT = "BIG ENDIAN";
    private SystemUtil()
    {
    }

    public static void changeEndian(ByteBuffer byteBuffer)
    {
        byteBuffer.order(byteBuffer.order() == ByteOrder.BIG_ENDIAN ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
    }

    public static ByteOrder getEndian(ByteBuffer byteBuffer)
    {
        return byteBuffer.order();
    }

    public static String endianText(ByteBuffer byteBuffer)
    {
        return byteBuffer.order() == ByteOrder.LITTLE_ENDIAN ? LITTLE_ENDIAN_TEXT : BIG_ENDIAN_TEXT;
    }


    public static boolean isLittleEndian()
    {
        return ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
    }

    public static boolean isBigEndian()
    {
        return !isLittleEndian();
    }

    public static String endianText()
    {
        return isLittleEndian() ? LITTLE_ENDIAN_TEXT : BIG_ENDIAN_TEXT;
    }

    public Path userDirectoryPath()
    {
        return Path.of(System.getProperty("user.dir"));
    }

    //...
}
