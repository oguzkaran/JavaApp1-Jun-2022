/*----------------------------------------------------------------------
	FILE        : Command.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 04.09.2022

	Annotation for CommandPrompt

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/

package org.csystem.util.console.commandprompt;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Commands.class)
public @interface Command {
    String value() default "";
}