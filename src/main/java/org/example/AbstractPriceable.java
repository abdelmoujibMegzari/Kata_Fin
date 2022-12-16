package org.example;

public abstract class AbstractPriceable extends Entity implements Priceable{

    public AbstractPriceable(String name) {
        super(name);
    }

    @Override
    public float getPrice(Currency currency) {
        return currency.euroToCurrency(getPrice());
    }

    @Override
    public float getPrice(int quantity) {
        return getPrice()*quantity;
    }
}
