package com.mobolajialabi.burgers.models;


public class CartBurger {
    private final int image;
    private final String name;
    private final String price;

    public CartBurger(int image, String price, String name) {
        this.image = image;
        this.price = price;
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

}
