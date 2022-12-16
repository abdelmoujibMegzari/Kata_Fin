package org.example;

public class Price {
    float value;
    Currency currency;
    public Price(float value,Currency currency){
        this.value= value;
        this.currency=currency;
    }

    public float getValue(){
        return currency.toEuro(value);
    }
}
