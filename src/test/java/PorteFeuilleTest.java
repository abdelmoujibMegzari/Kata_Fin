import org.example.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PorteFeuilleTest {
    @Test
    public void testGetPrice() {
        // Create a PorteFeuille object
        PorteFeuille portefeuille = new PorteFeuille("Portefeuille 1");
        // The price of the PorteFeuille object should be 0 EUR
        assertEquals(0f, portefeuille.getPrice(), 0f);

        // Create a Product object and add it to the PorteFeuille object
        Product product = new Product("Product 1", portefeuille);
        new Underlying("Underlying 1", product, new Price(10f, new Currency("USD", "EUR", 1.5f)));
        // The price of the PorteFeuille object should be 10 EUR
        assertEquals(0f, portefeuille.getPrice(), 0f);

        // Create a Client object and add the Product object to its portfolio
        Client client = new Client("Client 1");
        client.addToPortfolio(product, 5);
        // The price of the PorteFeuille object should now be 50 EUR
        assertEquals(75f, portefeuille.getPrice(), 0f);

        Product product2 = new Product("Product 2", portefeuille);
        new Underlying("Underlying 2", product2, new Price(20f, new Currency("EUR", "EUR", 1.0f)));
        // The price of the PorteFeuille object should now be 75 EUR because no client added the product to his portfolio
        assertEquals(75f, portefeuille.getPrice(), 0f);

        // Create another Client object and add the second Product object to its portfolio
        Client client2 = new Client("Client 2");
        client2.addToPortfolio(product2, 3);
        client2.addToPortfolio(product, 1);
        // The price of the PorteFeuille object should now be 150 EUR because the second Product object is priced in EUR and the quantity added is 3 and we added one of the first product
        assertEquals(150f, portefeuille.getPrice(), 0f);
    }
}
