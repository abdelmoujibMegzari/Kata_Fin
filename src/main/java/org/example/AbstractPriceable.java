package org.example;

/**
 * The AbstractPriceable class is an abstract class that represents an object with a price.
 * It extends the Entity class and implements the Priceable interface.
 */
public abstract class AbstractPriceable extends Entity implements Priceable {
    /**
     * Constructor that takes a single parameter: name.
     * Initializes the name field inherited from the Entity class with the name parameter.
     *
     * @param name the name of the object
     */
    public AbstractPriceable(String name) {
        // Call the constructor of the parent class, Entity, and pass it the name parameter
        super(name);
    }

    /**
     * Returns the price of the object in the currency represented by the currency parameter.
     * Does this by calling the euroToCurrency method of the currency parameter to convert the price from euros to the desired currency.
     *
     * @param currency the currency in which to return the price
     * @return the price of the object in the currency represented by the currency parameter
     */
    @Override
    public float getPrice(Currency currency) {
        // Call the getPrice method, which is implemented by a subclass of AbstractPriceable, to get the price in euros
        return currency.euroToCurrency(getPrice());
    }

    /**
     * Returns the price of the object multiplied by the quantity parameter.
     *
     * @param quantity the quantity of the object
     * @return the price of the object multiplied by the quantity parameter, in euros
     */
    @Override
    public float getPrice(int quantity) {
        // Call the getPrice method, which is implemented by a subclass of AbstractPriceable, to get the price in euros
        // Multiply the price by the quantity parameter and return the result
        return getPrice() * quantity;
    }

    /**
     * Returns the price of the object multiplied by the quantity parameter, in the currency represented by the currency parameter.
     *
     * @param quantity the quantity of the object
     * @param currency the currency in which to return the price
     * @return the price of the object multiplied by the quantity parameter, in the currency represented by the currency parameter
     */
    @Override
    public float getPrice(int quantity, Currency currency) {
        // Call the getPrice method, which is implemented by a subclass of AbstractPriceable, to get the price in euros
        // Multiply the price by the quantity parameter and convert the result to the desired currency using the currency's euroToCurrency method
        return currency.euroToCurrency(getPrice() * quantity);
    }


    /**
     * This method is abstract and must be implemented by a subclass of AbstractPriceable.
     * It should return the price of the object in euros.
     *
     * @return the price of the object in euros
     */
    public abstract float getPrice();
}

