package com.mobolajialabi.burgers.models;

import java.text.NumberFormat;

import static java.lang.Integer.parseInt;

public class MainBurger {
    private final String dishName;
    private final String generalName;
    private final String price;
    private final int image;

    public MainBurger(String dishName, String generalName, String price, int image) {
        this.dishName = dishName;
        this.generalName = generalName;
        this.price = (NumberFormat.getCurrencyInstance().format(parseInt(price)));
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getDishName() {
        return dishName;
    }

    public String getGeneralName() {
        return generalName;
    }
}
