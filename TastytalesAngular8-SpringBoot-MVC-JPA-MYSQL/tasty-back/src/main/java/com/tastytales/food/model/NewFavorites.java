package com.tastytales.food.model;

public class NewFavorites {

    private int quantity;

    public NewFavorites(){}

    public NewFavorites(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "NewFavorites{" +
                "quantity=" + quantity +
                '}';
    }
}
