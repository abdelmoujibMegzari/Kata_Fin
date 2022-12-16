package org.example;

import java.util.HashMap;

public class Currency extends Entity{
    private final float valueInEuro;

    public Currency(String name1, String name2,float value){
        super(name2.equals("EUR")?name1:name2);
        this.valueInEuro= name2.equals("EUR")?value :1/value;
    }

    public float toEuro(float amount){
        return amount* valueInEuro;
    }

    public float euroToCurrency(float amountInEuro){
        return amountInEuro/valueInEuro;
    }

}
