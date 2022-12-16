package org.example;

public interface Priceable {
    public float getPrice();
    public float getPrice(Currency currency);
    public float getPrice(int quantity);
}
