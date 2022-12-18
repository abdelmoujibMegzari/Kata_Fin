import org.example.Currency;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CurrencyTest {
    @Test
    public void testToEuro() {
        // Test converting USD to EUR
        Currency usd = new Currency("USD", "EUR", 0.8f);
        assertEquals(0.8f, usd.toEuro(1.0f), 0.01f);
        assertEquals(16.0f, usd.toEuro(20.0f), 0.01f);

        // Test converting USD to EUR
        usd = new Currency("EUR", "USD", 1.25f);
        assertEquals(0.8f, usd.toEuro(1.0f), 0.01f);
        assertEquals(16.0f, usd.toEuro(20.0f), 0.01f);

        // Test converting GBP to EUR
        Currency gbp = new Currency("GBP", "EUR", 1.2f);
        assertEquals(1.2f, gbp.toEuro(1.0f), 0.01f);
        assertEquals(24.0f, gbp.toEuro(20.0f), 0.01f);

        // Test converting EUR to EUR
        Currency eur = new Currency("EUR", "EUR", 1.0f);
        assertEquals(1.0f, eur.toEuro(1.0f), 0.001f);
        assertEquals(2.0f, eur.toEuro(2.0f), 0.001f);
        assertEquals(0.625f, eur.toEuro(0.625f), 0.001f);
    }

    @Test
    public void testEuroToCurrency() {
        // Test converting USD to EUR
        Currency usd = new Currency("USD", "EUR", 0.8f);
        assertEquals(1.25f, usd.euroToCurrency(1.0f), 0.01f);
        assertEquals(25.0f, usd.euroToCurrency(20.0f), 0.01f);

        // Test converting USD to EUR
        usd = new Currency("EUR", "USD", 1.25f);
        assertEquals(1.25f, usd.euroToCurrency(1.0f), 0.01f);
        assertEquals(25.0f, usd.euroToCurrency(20.0f), 0.01f);

        // Test converting GBP to EUR
        Currency gbp = new Currency("GBP", "EUR", 1.2f);
        assertEquals(0.83f, gbp.euroToCurrency(1.0f), 0.01f);
        assertEquals(16.67f, gbp.euroToCurrency(20.0f), 0.01f);

        // Test converting EUR to EUR
        Currency eur = new Currency("EUR", "EUR", 1.0f);
        assertEquals(1.0f, eur.euroToCurrency(1.0f), 0.001f);
        assertEquals(2.0f, eur.euroToCurrency(2.0f), 0.001f);
    }
}

