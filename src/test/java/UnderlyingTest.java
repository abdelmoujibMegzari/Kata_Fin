import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnderlyingTest {
    @Test
    public void testUnderlying() {
        // Create a Currency object with the name "USD", converting to "EUR", and a value of 0.9
        Currency currency = new Currency("USD", "EUR", 0.9f);
        // Create a Price object with a value of 100 and the currency object created above
        Price price = new Price(100, currency);
        // Create a Product object with the name "Stock" and a PorteFeuille object with the name "Portfolio"
        Product product = new Product("Stock", new PorteFeuille("Portfolio"));
        // Create an Underlying object with the name "Apple", the product object created above, and the price object created above
        Underlying underlying = new Underlying("Apple", product, price);
        // Assert that the getPrice method of the underlying object returns 90 (100 * 0.9)
        assertEquals(90, underlying.getPrice(), 0.0001);
    }
}
