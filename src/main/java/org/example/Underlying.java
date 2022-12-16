package org.example;


import java.util.HashMap;
import java.util.HashSet;

public class Underlying extends AbstractPriceable {
    //private static final HashMap<String,Underlying> underlyings=new HashMap<>();

    //public Underlying getUnderying(String name){
    //    if(underlyings.containsKey(name)) return underlyings.get(name);
    //    return null;

    //}

    private final Price  price;


    public Underlying(String name,Product product,Price price){
        super(name);
        this.price=price;
        product.addUnderlying(this);
        //underlyings.put(name,this);
    }

    public float getPrice() {
        return price.getValue();
    }

}
