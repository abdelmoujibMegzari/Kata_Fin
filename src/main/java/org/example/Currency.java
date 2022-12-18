package org.example;

import java.util.HashMap;

// Currency class that extends the Entity class
public class Currency extends Entity {
    // Value of the currency in euros
    private final float valueInEuro;

    // Constructor that takes three parameters: name1, name2, and value
    // name1 is the name of the currency being converted
    // name2 is the name of the currency to convert to
    // value is the value of currency name1 in currency name2 (i.e. 1 name1 equals value name2)
    public Currency(String name1, String name2, float value) {
        // Call the constructor of the parent class, Entity
        // If name2 is not "EUR", initialize the name field of the parent class with name2
        // Otherwise, initialize the name field with name1
        super(name2.equals("EUR") ? name1 : name2);

        // value is the value of currency name1 in currency name2
        // If name2 is "EUR", valueInEuro is equal to value
        // Otherwise, valueInEuro is equal to 1/value
        this.valueInEuro = name2.equals("EUR") ? value : 1 / value;
    }

    // Converts a given amount of the currency to euros
    public float toEuro(float amount) {
        return amount * valueInEuro;
    }

    // Converts a given amount of euros to the currency
    public float euroToCurrency(float amountInEuro) {
        return amountInEuro / valueInEuro;
    }
}
