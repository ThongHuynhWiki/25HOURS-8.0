package com.example.designprofile.profile.menuprofile.myactivities;

public class ItemProduct {
    private int logo;
    private String name;
    private float price;
    private int points;
    private int quantity;

    public ItemProduct(int logo, String name, float price, int points, int quantity) {
        this.logo = logo;
        this.name = name;
        this.price = price;
        this.points = points;
        this.quantity = quantity;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
