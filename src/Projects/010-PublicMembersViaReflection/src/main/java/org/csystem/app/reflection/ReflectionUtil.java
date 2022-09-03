package org.csystem.app.reflection;

import org.csystem.util.console.Console;

import java.lang.reflect.Parameter;

public class ReflectionUtil {
    private static String getParametersListAsString(Parameter [] parameters)
    {
        var sb = new StringBuilder();

        for (var parameter : parameters)
            sb.append(parameter.getType().getSimpleName()).append(' ').append(parameter.getName()).append(", ");

        return parameters.length != 0 ? sb.substring(0, sb.length() - 2) : "";
    }

    public static void printMethods(Class<?> cls)
    {
        Console.writeLine("METHODS");

        var methods = cls.getMethods();

        for (var method : methods) {
            var returnCls = method.getReturnType();
            var parameters = method.getParameters();
            Console.writeLine("%s %s(%s)", returnCls.getSimpleName(), method.getName(), getParametersListAsString(parameters));
        }

        Console.writeLine("-------------------------------------------------");
    }

    public static void printFields(Class<?> cls)
    {
        Console.writeLine("FIELDS");

        for (var field : cls.getFields())
            Console.writeLine("%s %s", field.getType().getSimpleName(), field.getName());

        Console.writeLine("-------------------------------------------------");
    }

    public static void printConstructors(Class<?> cls)
    {
        Console.writeLine("CONSTRUCTORS");
        for (var ctor : cls.getConstructors())
            Console.writeLine("%s(%s)", ctor.getName(), getParametersListAsString(ctor.getParameters()));
    }
}
