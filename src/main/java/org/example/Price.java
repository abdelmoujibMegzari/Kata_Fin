package org.example;

// The Price class represents the price of something in a specific currency
public class Price {
    // The value of the price, in the currency represented by the currency field
    float value;

    // The currency in which the price is expressed
    Currency currency;

    // Constructor that takes two parameters: value and currency
    // value is the price of the item, in the currency represented by the currency field
    // currency is an object of the Currency class that represents the currency in which the price is expressed
    public Price(float value,Currency currency){
        // Initialize the value field with the value parameter
        this.value= value;

        // Initialize the currency field with the currency parameter
        this.currency=currency;
    }

    // Returns the value of the price in euros
    // Does this by calling the toEuro method of the currency field, which converts the value field from the currency represented by the currency field to euros
    public float getValue(){
        return currency.toEuro(value);
    }
}