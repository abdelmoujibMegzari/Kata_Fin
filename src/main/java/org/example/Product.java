package org.example;

import java.util.HashSet;

/**
 * The Product class represents a financial product that is being traded on the financial markets.
 * It extends the AbstractPriceable class and represents an object with a price.
 *
 * A financial product is a financial instrument that is bought and sold on the financial markets, such as a stock, bond, or derivative.
 */
public class Product extends AbstractPriceable {
    /**
     * A set of Underlying objects that make up this Product.
     */
    private final HashSet<Underlying> underlyings = new HashSet<>();
    /**
     * A set of Client objects that have this Product in their portfolio.
     */
    private final HashSet<Client> clients = new HashSet<>();
    //I chose to store the list of clients and not only the total amount in case we want to implement later modifications of cart

    /**
     * Constructor that takes two parameters: name and porteFeuille.
     * Initializes the name field inherited from the AbstractPriceable class with the name parameter.
     * Calls the add_Product method of the porteFeuille parameter and passes it this Product object.
     *
     * @param name the name of the product
     * @param porteFeuille the portfolio that this product belongs to
     */
    public Product(String name, PorteFeuille porteFeuille) {
        // Call the constructor of the parent class, AbstractPriceable, and pass it the name parameter
        super(name);
        // Call the add_Product method of the porteFeuille parameter and pass it this Product object
        porteFeuille.add_Product(this);
    }

    /**
     * Adds a Client object to the set of clients that have this Product in their portfolio.
     *
     * @param client the Client object to add
     */
    protected void addClient(Client client) {
        // Add the client parameter to the clients set
        clients.add(client);
    }

    /**
     * Adds an Underlying object to the set of underlyings that make up this Product.
     *
     * @param underlying the Underlying object to add
     */
    protected void addUnderlying(Underlying underlying) {
        // Add the underlying parameter to the underlyings set
        underlyings.add(underlying);
    }

    /**
     * Returns the price of this Product.
     * The price is calculated by summing the prices of all the Underlying objects in the underlyings set.
     *
     * @return the price of this Product
     */
    @Override
    public float getPrice() {
        // Initialize a totalPrice variable to 0
        float totalPrice = 0;
        // Iterate through the underlyings set
        for (Underlying underlying : underlyings) {
            // Add the price of the current underlying to the totalPrice variable
            totalPrice += underlying.getPrice();
        }
        // Return the totalPrice variable
        return totalPrice;
    }


    /**
     * Returns the total quantity of this Product in the portfolios of all the Client objects in the clients set.
     *
     * @return the total quantity of this Product in the portfolios of all the Client objects in the clients set
     */
    public int getAmount() {
        // Initialize a totalAmount variable to 0
        int totalAmount = 0;
        // Iterate through the clients set
        for (Client client : clients) {
            // Add the quantity of this Product in the portfolio of the current client to the totalAmount variable
            totalAmount += client.getQuantity(this);
        }
        // Return the totalAmount variable
        return totalAmount;
    }
}
