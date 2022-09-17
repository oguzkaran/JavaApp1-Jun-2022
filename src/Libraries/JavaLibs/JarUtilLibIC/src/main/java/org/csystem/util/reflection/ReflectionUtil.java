/*----------------------------------------------------------------------
	FILE        : ReflectionUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 10.09.2022

	ReflectionUtil class dynamic jar operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.reflection;

import java.io.Console;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class ReflectionUtil {
    private static final FilenameFilter ms_filenameFilter = (f, name) -> name.endsWith(".jar");

    private static String getClassName(JarEntry jarEntry)
    {
        String className = jarEntry.getName().replace("/", ".");

        className = className.substring(0, className.lastIndexOf("."));

        return className;
    }

    private ReflectionUtil() {}

    public static ParamInfo makeParamInfo(short val)
    {
        return new ParamInfo(short.class, val);
    }

    public static ParamInfo makeParamInfo(int val)
    {
        return new ParamInfo(int.class, val);
    }

    public static ParamInfo makeParamInfo(long val)
    {
        return new ParamInfo(long.class, val);
    }

    public static ParamInfo makeParamInfo(byte val)
    {
        return new ParamInfo(byte.class, val);
    }

    public static ParamInfo makeParamInfo(float val)
    {
        return new ParamInfo(float.class, val);
    }

    public static ParamInfo makeParamInfo(double val)
    {
        return new ParamInfo(double.class, val);
    }

    public static ParamInfo makeParamInfo(char val)
    {
        return new ParamInfo(char.class, val);
    }

    public static ParamInfo makeParamInfo(boolean val)
    {
        return new ParamInfo(boolean.class, val);
    }

    public static ParamInfo makeParamInfo(String str) { return new ParamInfo(String.class, str); }

    public static <T> ParamInfo makeParamInfo(Class<T> cls, T val)
    {
        return new ParamInfo(cls, val);
    }

    public static class ParamInfo {
        private final Class<?> m_paramClass;
        private final Object m_param;

        public ParamInfo(Class<?> paramClass, Object param)
        {
            m_paramClass = paramClass;
            m_param = param;
        }
    }

    public static Object callMethod(Class<?> cls, String methodName, ParamInfo...paramInfos)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        Object obj = cls.getConstructor().newInstance();
        Class<?> []paramClasses = new Class<?>[paramInfos.length];
        Object [] params = new Object[paramInfos.length];

        int len = paramInfos.length;

        for (int i = 0; i < len; ++i) {
            ParamInfo pi = paramInfos[i];

            paramClasses[i] = pi.m_paramClass;
            params[i] = pi.m_param;
        }

        Method method = cls.getMethod(methodName, paramClasses);

        return method.invoke(obj, params);
    }

    public static <T> List<Class<?>> getImplementedClassesByJar(String filePath, String tStr)
            throws IOException, ClassNotFoundException
    {
        URL[] urls = {new URL("jar:file:" + filePath + "!/")};

        try (JarFile jarFile = new JarFile(filePath); URLClassLoader cl = new URLClassLoader(urls)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            List<Class<?>> list = new ArrayList<>();
            var tCls = Class.forName(tStr);

            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();

                if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class"))
                    continue;

                Class<?> cls = cl.loadClass(getClassName(jarEntry));

                if (cls.isInterface() || cls == tCls)
                    continue;

                if (tCls.isAssignableFrom(cls))
                    list.add(cls);
            }

            return list;
        }
    }

    public static <T> List<Class<?>> getImplementedClassesByJar(String filePath, Class<T> tCls)
            throws IOException, ClassNotFoundException
    {
        URL[] urls = {new URL("jar:file:" + filePath + "!/")};

        try (JarFile jarFile = new JarFile(filePath); URLClassLoader cl = new URLClassLoader(urls)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            List<Class<?>> list = new ArrayList<>();

            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();

                if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class"))
                    continue;

                Class<?> cls = cl.loadClass(getClassName(jarEntry));

                if (cls.isInterface() || cls == tCls)
                    continue;

                if (tCls.isAssignableFrom(cls))
                    list.add(cls);
            }

            return list;
        }
    }

    public static <T> List<Class<?>> getImplementedClassesByJars(String dirPath, Class<T> tCls)
            throws IOException, ClassNotFoundException
    {
        File [] jarFiles = new File(dirPath).listFiles(ms_filenameFilter);
        List<Class<?>> list = new ArrayList<>();

        if (jarFiles == null)
            return list;


        for (File jarFile : jarFiles) {
            List<Class<?>> classList = getImplementedClassesByJar(jarFile.getAbsolutePath(), tCls);

            if (!classList.isEmpty())
                list.addAll(classList);
        }

        return list;
    }

    public static <T> List<Class<?>> getImplementedClassesByJars(String dirPath, String tStr)
            throws IOException, ClassNotFoundException
    {
        File [] jarFiles = new File(dirPath).listFiles(ms_filenameFilter);
        List<Class<?>> list = new ArrayList<>();

        if (jarFiles == null)
            return list;

        System.out.println(jarFiles.length);
        for (File jarFile : jarFiles) {
            List<Class<?>> classList = getImplementedClassesByJar(jarFile.getAbsolutePath(), tStr);

            if (!classList.isEmpty())
                list.addAll(classList);
        }

        return list;
    }
}
