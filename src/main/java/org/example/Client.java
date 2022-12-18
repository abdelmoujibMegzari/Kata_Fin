package org.example;

import java.util.HashMap;

/**
 * The Client class represents a client of a financial product.
 * It has a name and a portfolio of financial products.
 *
 * A client is an individual or organization that buys financial products from a financial institution.
 */
public class Client extends AbstractPriceable {
    /**
     * A HashMap that maps Product objects to Integer objects representing the quantities of the products in the client's portfolio.
     */
    private HashMap<Product, Integer> portfolio = new HashMap<>();

    /**
     * Constructor that takes one parameter: name.
     * Initializes the name field inherited from the Entity class with the name parameter.
     *
     * @param name the name of the client
     */
    public Client(String name) {
        // Call the constructor of the parent class, Entity, and pass it the name parameter
        super(name);
    }


    /**
     * Adds a given quantity of a given Product object to the client's portfolio.
     *
     * @param product the Product object to add
     * @param quantity the quantity of the product to add
     */
    public void addToPortfolio(Product product, int quantity) {
        // Check if the portfolio HashMap already contains the product parameter
        if (portfolio.containsKey(product)) {
            // If it does, add the quantity parameter to the existing value in the HashMap
            portfolio.put(product, portfolio.get(product) + quantity);
        } else {
            // If it doesn't, add the product-quantity pair to the HashMap
            portfolio.put(product, quantity);
        }
        product.addClient(this);
    }


    /**
     * Calculates the total price of all the products in the client's portfolio.
     *
     * @return the total price of all the products in the client's portfolio
     */
    @Override
    public float getPrice() {
        float totalPrice = 0;
        // Loop through the keys in the portfolio HashMap
        for (Product product: portfolio.keySet()) {
            // Calculate the total price of the product by calling the getPrice method of the product with the corresponding quantity in the HashMap as an argument
            totalPrice += product.getPrice(portfolio.get(product));
        }
        // Return the total price of all the products in the client's portfolio
        return totalPrice;
    }
    /**
     * Returns the quantity of a given product in the client's portfolio.
     *
     * @param product the Product object whose quantity is to be returned
     * @return the quantity of the given product in the client's portfolio
     */
    public int getQuantity(Product product) {
        // Return the quantity of the given product in the client's portfolio, or 0 if the product is not in the portfolio
        return portfolio.getOrDefault(product, 0);
    }

}
