package depaul.edu.tests;

import org.junit.jupiter.api.Test;

import depaul.edu.catalog.ProductFactory;
import depaul.edu.models.Book;
import depaul.edu.models.Product;
import depaul.edu.models.Speaker;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    @Test
    void testGetProductBook() {
        Product product = ProductFactory.getProduct("book", "1", "Effective Java", 50.00, "Java programming guide");
        assertNotNull(product);
        assertTrue(product instanceof Book);
        assertEquals("1", product.getId());
        assertEquals("Effective Java", product.getName());
        assertEquals(50.00, product.getPrice(), 0.001);
        assertEquals("Java programming guide", product.getDescription());
    }

    @Test
    void testGetProductSpeaker() {
        Product product = ProductFactory.getProduct("speaker", "2", "Bluetooth Speaker", 99.99, "Portable speaker");
        assertNotNull(product);
        assertTrue(product instanceof Speaker);
        assertEquals("2", product.getId());
        assertEquals("Bluetooth Speaker", product.getName());
        assertEquals(99.99, product.getPrice(), 0.001);
        assertEquals("Portable speaker", product.getDescription());
    }

    @Test
    void testGetProductWithNullValues() {
        assertThrows(IllegalArgumentException.class, () -> ProductFactory.getProduct(null, "1", "Effective Java", 50.00, "Java programming guide"));
    }

    @Test
    void testGetProductWithEmptyValues() {
        assertThrows(IllegalArgumentException.class, () -> ProductFactory.getProduct("", "1", "Effective Java", 50.00, "Java programming guide"));
    }

    @Test
    void testGetProductWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> ProductFactory.getProduct("book", "1", "Effective Java", -50.00, "Java programming guide"));
    }
    
}

   
