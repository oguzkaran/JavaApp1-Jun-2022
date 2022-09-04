/*----------------------------------------------------------------------------------------------------------------------
    ConsoleLib içersideki CommandPrompt ve annotation'ları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandprompt.Command;
import org.csystem.util.console.commandprompt.CommandPrompt;
import org.csystem.util.console.commandprompt.Commands;

class App {
    public static void main(String[] args)
    {
       var app = new CommandPromptApp();

       app.run();
    }
}

class CommandPromptApp {
    private final CommandPrompt m_commandPrompt;
    private void doList()
    {
        Console.writeLine("doList");
    }

    @Command("ls")
    @Command("dir")
    @Command
    private void list(String path)
    {
        Console.writeLine("list:%s", path);
    }

    @Commands({@Command("cp"), @Command})
    private void copy(String src, String dest)
    {
        Console.writeLine("copy from %s to %s", src, dest);
    }

    @Command("change")
    @Command("chg")
    private void changePrompt(String prompt)
    {
        m_commandPrompt.setPrompt(prompt);
    }

    @Command("exit")
    @Command
    private void quit()
    {
        Console.writeLine("C and System Programmers Association");
        System.exit(0);
    }

    public CommandPromptApp()
    {
        m_commandPrompt = new CommandPrompt.Builder()
                .register(this)
                .setPromptSuffix(">")
                .setPrompt("CSD")
                .setInvalidCommandMessage("Geçersiz komut")
                .setWrongNumberOfArgumentsMessage("Geçersiz argüman sayısı")
                .build();
    }

    public void run()
    {
        m_commandPrompt.run();
    }
}

