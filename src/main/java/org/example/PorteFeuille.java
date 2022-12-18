package org.example;

import java.util.HashSet;

/**
 * The PorteFeuille class represents a portfolio of financial products.
 * It extends the AbstractPriceable class and represents an object with a price.
 *
 * A portfolio is a collection of financial products that are owned by a particular individual or organization.
 */
public class PorteFeuille extends AbstractPriceable {
    /**
     * A set of Product objects that are in this portfolio.
     */
    private HashSet<Product> productsList = new HashSet<>();

    /**
     * Constructor that takes one parameter: name.
     * Initializes the name field inherited from the AbstractPriceable class with the name parameter.
     *
     * @param name the name of the portfolio
     */
    public PorteFeuille(String name) {
        // Call the constructor of the parent class, AbstractPriceable, and pass it the name parameter
        super(name);
    }

    /**
     * Adds a Product object to the set of products in this portfolio.
     * This method is meant to be used by the Product class only.
     *
     * @param product the Product object to add
     */
    protected void add_Product(Product product) {
        // Add the product parameter to the productsList set
        productsList.add(product);
    }
    // This is meant to be used by product only I am thinking about nested classes as in product inside portefeuille and underlying inside Product so that the addition is done in the moment of the creation

    /**
     * Returns the price of this PorteFeuille.
     * The price is calculated by summing the prices of all the Product objects in the productsList set, multiplied by their respective quantities in the portfolio.
     *
     * @return the price of this PorteFeuille
     */
    @Override
    public float getPrice() {
        // Initialize a totalPrice variable to 0
        float totalPrice = 0;
        // Iterate through the productsList set
        for (Product product : productsList) {
            // Add the price of the current product multiplied by its quantity in the portfolio to the totalPrice variable
            totalPrice += product.getPrice() * product.getAmount();
        }
        // Return the totalPrice variable
        return totalPrice;
    }

}
