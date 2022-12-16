package org.example;

import java.util.HashMap;

public class Client extends AbstractPriceable {

    private final HashMap<Product,Integer> cart = new HashMap<>();

    public Client(String name){
        super(name);
    }

    public void addToCart(Product product,Integer quantity){
        //TODO for now add to cart replaces the old quantity by the new one
        cart.put(product,quantity);
        product.addClient(this);
    }


    @Override
    public float getPrice() {
       float totalPrice=0;
        for (Product product: cart.keySet()) {
            totalPrice+=product.getPrice(cart.get(product));
        }
        return totalPrice;
    }
    public int getQuantity(Product product){
        return cart.getOrDefault(product, 0);
    }
}
