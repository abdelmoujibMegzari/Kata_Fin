package org.example;

/**
 * The Underlying class represents an underlying asset of a financial product.
 * It extends the AbstractPriceable class and represents an object with a price.
 *
 * An underlying asset is the asset that is being traded on the financial markets, such as a stock, commodity, or currency.
 */
public class Underlying extends AbstractPriceable {

    /**
     * The price of the underlying asset.
     */
    private final Price  price;

    /**
     * Constructor that takes three parameters: name, product, and price.
     * Initializes the name field inherited from the AbstractPriceable class with the name parameter.
     * Also initializes the price field with the price parameter.
     * Calls the addUnderlying method of the product parameter and passes it this Underlying object.
     *
     * @param name the name of the underlying asset
     * @param product the product that this underlying asset belongs to
     * @param price the price of the underlying asset
     */
    public Underlying(String name, Product product, Price price) {
        // Call the constructor of the parent class, AbstractPriceable, and pass it the name parameter
        super(name);
        // Initialize the price field with the price parameter
        this.price = price;
        // Call the addUnderlying method of the product parameter and pass it this Underlying object
        product.addUnderlying(this);
    }

    /**
     * Returns the price of the underlying asset, in Euro.
     * This is done by calling the getValue method of the price field and returning the result.
     *
     * @return the price of the underlying asset
     */
    @Override
    public float getPrice() {
        // Return the result of calling the getValue method of the price field
        return price.getValue();
    }

}
