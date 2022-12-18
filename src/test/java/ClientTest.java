import org.example.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    @Test
    public void testGetQuantity() {
        // Create a Client object
        Client client = new Client("Client 1");

        // Create a PorteFeuille object
        PorteFeuille portefeuille = new PorteFeuille("Portefeuille 1");

        // Create a Product object and add it to the PorteFeuille object
        Product product1 = new Product("Product 1", portefeuille);
        new Underlying("Underlying 1", product1, new Price(10f, new Currency("USD", "EUR", 1.5f)));

        // The quantity of the Product object in the Client object's portfolio should be 0
        assertEquals(0, client.getQuantity(product1));

        // Add the Product object to the Client object's portfolio
        client.addToPortfolio(product1, 5);
        // The quantity of the Product object in the Client object's portfolio should now be 5
        assertEquals(5, client.getQuantity(product1));

        // Create another Product object and add it to the PorteFeuille object
        Product product2 = new Product("Product 2", portefeuille);
        new Underlying("Underlying 2", product2, new Price(20f, new Currency("EUR", "EUR", 1.0f)));

        // The quantity of the second Product object in the Client object's portfolio should be 0
        assertEquals(0, client.getQuantity(product2));

        // Add the second Product object to the Client object's portfolio
        client.addToPortfolio(product2, 3);
        // The quantity of the second Product object in the Client object's portfolio should now be 3
        assertEquals(3, client.getQuantity(product2));

        // Modify the quantity of the first Product object in the Client object's portfolio
        client.addToPortfolio(product1, 2);
        // The quantity of the first Product object in the Client object's portfolio should now be 7
        assertEquals(7, client.getQuantity(product1));
    }

    @Test
    public void testGetPrice() {
        // Create a Client object
        Client client = new Client("Client 1");
        // The price of the Client object should be 0 EUR
        assertEquals(0f, client.getPrice(), 0f);

        // Create a PorteFeuille object
        PorteFeuille portefeuille = new PorteFeuille("Portefeuille 1");

        // Create a Product object and add it to the PorteFeuille object
        Product product1 = new Product("Product 1", portefeuille);
        new Underlying("Underlying 1", product1, new Price(10f, new Currency("USD", "EUR", 1.5f)));

        // Add the Product object to the Client object's portfolio
        client.addToPortfolio(product1, 5);
        // The price of the Client object should now be 75 EUR because the Product object is priced in USD and must be converted to EUR
        assertEquals(75f, client.getPrice(), 0f);

        PorteFeuille portefeuille2 = new PorteFeuille("Portefeuille 2");
        // Create another Product object and add it to the PorteFeuille object
        Product product2 = new Product("Product 2", portefeuille2);
        new Underlying("Underlying 2", product2, new Price(20f, new Currency("EUR", "EUR", 1.0f)));

        // Add the second Product object to the Client object's portfolio
        client.addToPortfolio(product2, 3);
        // The price of the Client object should now be 135 EUR because the second Product object is priced in EUR
        assertEquals(135f, client.getPrice(), 0f);

        // Modify the quantity of the first Product object in the Client object's portfolio
        client.addToPortfolio(product1, 2);
        // The price of the Client object should now be 165 EUR because the quantity of the first Product object in the portfolio has been modified
        assertEquals(165f, client.getPrice(), 0f);
    }
}
