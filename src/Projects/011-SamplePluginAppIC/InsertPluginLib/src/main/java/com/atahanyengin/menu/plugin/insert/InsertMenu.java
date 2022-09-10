package com.atahanyengin.menu.plugin.insert;

import com.eraytasay.menu.plugin.IMenuPlugin;

public class InsertMenu implements IMenuPlugin {
    @Override
    public String menuText()
    {
        return "Insert";
    }

    @Override
    public void doWork(Object... objects)
    {
        System.out.println("Insert Operation");
    }
}
