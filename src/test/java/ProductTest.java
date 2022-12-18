import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void testProduct() {
        Currency usd = new Currency("USD", "EUR", 0.8f);
        PorteFeuille porteFeuille = new PorteFeuille("Porte-feuille 1");
        Product product = new Product("Product 1", porteFeuille);

        // Test price and amount with no underlying products
        assertEquals(0.0f, product.getPrice(), 0.0001f);
        assertEquals(0, product.getAmount());

        // Add underlying products
        Underlying underlying1 = new Underlying("Underlying 1", product, new Price(100.0f, usd));
        Underlying underlying2 = new Underlying("Underlying 2", product, new Price(50.0f, usd));
        Underlying underlying3 = new Underlying("Underlying 3", product, new Price(25.0f, usd));

        // Test price and amount with underlying products
        assertEquals(140.0f, product.getPrice(), 0.0001f);
        assertEquals(0, product.getAmount());

        // Add clients
        Client client1 = new Client("Client 1");
        Client client2 = new Client("Client 2");
        Client client3 = new Client("Client 3");

        // Test price and amount with clients
        client1.addToPortfolio(product, 1);
        client2.addToPortfolio(product, 2);
        client3.addToPortfolio(product, 3);
        assertEquals(140.0f, product.getPrice(), 0.0001f);
        assertEquals(6, product.getAmount());
    }
}
