package com.eraytasay.menu.plugin;

public interface IMenuPlugin {
    String MENU_TEXT_METHOD_NAME = "menuText";
    String DO_WORK_METHOD_NAME = "doWork";
    String menuText();
    void doWork(Object...objects);
}
