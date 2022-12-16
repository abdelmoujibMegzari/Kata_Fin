package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PorteFeuille extends AbstractPriceable {

    private HashSet<Product> productsList = new HashSet<>();

    public PorteFeuille(String name){
        super(name);
    }
    protected void add_Product(Product product){
        productsList.add(product);
    } //this is meant to be used by product only I am thinking about nested classes as in product inside portefeuille and underlying inside Product so that the addition is done in the moment of the creation

    @Override
    public float getPrice() {//TODO this is wrong quantitites not taken into account
        float totalPrice=0;
        for (Product product:
                productsList) {
            totalPrice+=product.getPrice()*product.getAmount();
        }
        return totalPrice;

    }
}
