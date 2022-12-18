import org.example.Currency;
import org.example.Price;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PriceTest {
    @Test
    public void testGetValue() {
        Currency usd = new Currency("USD", "EUR", 0.8f);
        Price price = new Price(100.0f, usd);
        assertEquals(80.0f, price.getValue(), 0.01f);

        Currency gbp = new Currency("GBP", "EUR", 1.2f);
        price = new Price(100.0f, gbp);
        assertEquals(120.0f, price.getValue(), 0.01f);
    }
}
