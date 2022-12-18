package org.example;

// The Priceable interface defines methods for getting the price of an object
// in different currencies, quantities, and both currency and quantity.
public interface Priceable {
    // Returns the price of the object in Euro.
    float getPrice();

    // Returns the price of the object in the specified currency.
    float getPrice(Currency currency);

    // Returns the price of the object for the specified quantity in Euro.
    float getPrice(int quantity);

    // Returns the price of the object in the specified currency and quantity.
    float getPrice(int quantity, Currency currency);
}
