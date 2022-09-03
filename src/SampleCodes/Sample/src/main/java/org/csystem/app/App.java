/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.lang.annotation.*;

class App {
    public static void main(String[] args)
    {

    }
}

class CommandInfo {
    @Command("ls")
    @Command("dir")
    @Command
    public void list()
    {
        //...
    }

    @Commands({@Command("cp"), @Command})
    public void copy()
    {
        //...
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Commands.class)
@interface Command {
    String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Commands {
    Command [] value();
}



