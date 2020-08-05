package com.mobolajialabi.burgers.models;

public class IconBurger {
    private final int icon;
    private final String name;

    public IconBurger(int icon, String name){
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

}
