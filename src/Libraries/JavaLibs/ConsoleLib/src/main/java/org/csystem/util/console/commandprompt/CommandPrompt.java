/*----------------------------------------------------------------------
	FILE        : ErrorCommand.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 04.09.2022

	CommandPrompt class to manage "command prompt framework"

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.console.commandprompt;

import org.csystem.util.console.Console;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandPrompt {
    private Object m_regObject;
    private final ArrayList<MethodCallInfo> m_methodCallInfos = new ArrayList<>();
    private Method m_errorMethod;
    private String m_prompt = "csd";
    private String m_promptSuffix = "$";
    private String m_paramStringTypeErrorMessage = "Method parameters must be string";
    private String m_wrongNumberOfArgumentsMessage = "Wrong number of arguments";
    private String m_invalidCommandMessage = "Invalid command";

    private static class MethodCallInfo {
        String commandText;
        Method method;
        int argCount;

        MethodCallInfo(String commandText, Method method, int argCount)
        {
            this.commandText = commandText;
            this.method = method;
            this.argCount = argCount;
        }
    }

    private static boolean areAllString(Parameter [] parameters)
    {
        for (var param : parameters)
            if (param.getParameterizedType() != String.class)
                return false;

        return true;
    }

    private void registerCommands(Command [] commands, Method method)
    {
        for (var command : commands) {
            String value = command.value();
            String commandText = value.isBlank() ? method.getName() : value;

            var parameters = method.getParameters();
            if (!areAllString(parameters))
                throw new IllegalArgumentException(m_paramStringTypeErrorMessage);

            m_methodCallInfos.add(new MethodCallInfo(commandText, method, parameters.length));
        }
    }

    private void runCommands(String [] args, String [] params) throws InvocationTargetException, IllegalAccessException
    {
        boolean flag = false;
        boolean argsFlag = false;

        for (var methodCallInfo : m_methodCallInfos) {
            if (methodCallInfo.commandText.equals(args[0])) {
                flag = true;
                argsFlag = true;

                if (methodCallInfo.argCount != params.length) {
                    argsFlag = false;
                    continue;
                }

                methodCallInfo.method.setAccessible(true);
                methodCallInfo.method.invoke(m_regObject, (Object[])params);
                methodCallInfo.method.setAccessible(false);
                break;
            }
        }

        if (!flag)
            if (m_errorMethod != null) {
                m_errorMethod.setAccessible(true);
                m_errorMethod.invoke(m_regObject);
                m_errorMethod.setAccessible(true);
            }
            else
                Console.Error.writeLine(m_invalidCommandMessage);
        else if (!argsFlag)
            Console.Error.writeLine(m_wrongNumberOfArgumentsMessage);
    }

    private void register(Object regObject)
    {
        m_regObject = regObject;
        var clsRegObject = m_regObject.getClass();
        var methods = clsRegObject.getDeclaredMethods();

        for (var method : methods) {
            var commands = method.getDeclaredAnnotationsByType(Command.class);

            if (commands.length == 0) {
                if (m_errorMethod == null && method.getDeclaredAnnotation(ErrorCommand.class) != null
                        && method.getParameters().length == 0)
                    m_errorMethod = method;
                continue;
            }
            registerCommands(commands, method);
        }
    }

    private CommandPrompt()
    {
    }

    public void setPrompt(String prompt)
    {
        m_prompt = prompt;
    }

    public static class Builder {
        private final CommandPrompt m_commandPrompt = new CommandPrompt();

        public Builder register(Object regObject)
        {
            m_commandPrompt.register(regObject);

            return this;
        }

        public Builder setPrompt(String prompt)
        {
            m_commandPrompt.m_prompt = prompt;

            return this;
        }

        public Builder setPromptSuffix(String promptSuffix)
        {
            m_commandPrompt.m_promptSuffix = promptSuffix;

            return this;
        }

        public Builder setParamStringTypeErrorMessage(String paramStringTypeErrorMessage)
        {
            m_commandPrompt.m_paramStringTypeErrorMessage = paramStringTypeErrorMessage;

            return this;
        }

        public Builder setWrongNumberOfArgumentsMessage(String wrongNumberOfArgumentsMessage)
        {
            m_commandPrompt.m_wrongNumberOfArgumentsMessage = wrongNumberOfArgumentsMessage;
            return this;
        }

        public Builder setInvalidCommandMessage(String invalidCommandMessage)
        {
            m_commandPrompt.m_invalidCommandMessage = invalidCommandMessage;

            return this;
        }

        public CommandPrompt build()
        {
            return m_commandPrompt;
        }
    }

    public void run()
    {
        try {
            for (;;) {
                var cmd = Console.read(m_prompt + m_promptSuffix).strip();

                if (cmd.isEmpty())
                    continue;

                var args = cmd.split("[ \t]+");
                runCommands(args, Arrays.copyOfRange(args, 1, args.length));
            }
        }
        catch (Throwable ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
    }
}
