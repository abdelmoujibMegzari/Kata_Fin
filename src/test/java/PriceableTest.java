import static org.junit.Assert.assertEquals;

import org.example.*;
import org.junit.Test;

public class PriceableTest {
    @Test
    public void testGetPriceInEuro() {
        Currency usd = new Currency("USD", "EUR", 0.8f);
        Price price = new Price(100.0f, usd);
        PorteFeuille porteFeuille = new PorteFeuille("My PorteFeuille");
        Product product = new Product("My Product", porteFeuille);
        Underlying underlying = new Underlying("My Underlying", product, price);
        assertEquals(80.0f, underlying.getPrice(), 0.01f);
    }

    @Test
    public void testGetPriceInDifferentCurrency() {
        Currency usd = new Currency("USD", "EUR", 0.8f);
        Price price = new Price(100.0f, usd);
        PorteFeuille porteFeuille = new PorteFeuille("My PorteFeuille");
        Product product = new Product("My Product", porteFeuille);
        Underlying underlying = new Underlying("My Underlying", product, price);
        assertEquals(100.0f, underlying.getPrice(usd), 0.01f);
    }

    @Test
    public void testGetPriceForQuantity() {
        Currency usd = new Currency("USD", "EUR", 0.8f);
        Price price = new Price(100.0f, usd);
        PorteFeuille porteFeuille = new PorteFeuille("My PorteFeuille");
        Product product = new Product("My Product", porteFeuille);
        Underlying underlying = new Underlying("My Underlying", product, price);
        assertEquals(160.0f, underlying.getPrice(2), 0.01f);
    }

    @Test
    public void testGetPriceForQuantityInDifferentCurrency() {
        Currency usd = new Currency("USD", "EUR", 0.8f);
        Price price = new Price(100.0f, usd);
        PorteFeuille porteFeuille = new PorteFeuille("My PorteFeuille");
        Product product = new Product("My Product", porteFeuille);
        Underlying underlying = new Underlying("My Underlying", product, price);
        assertEquals(200.0f, underlying.getPrice(2, usd), 0.01f);
    }
}
