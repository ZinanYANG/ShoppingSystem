package depaul.edu.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import depaul.edu.catalog.ProductCatalog;
import depaul.edu.catalog.ProductFactory;
import depaul.edu.models.Product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

public class ProductCatalogTest {
    private ProductCatalog catalog;
    private Product book;
    private Product speaker;
    private Product book2;
    private Product speaker2;

    @BeforeEach
    public void setUp() {
        catalog = new ProductCatalog();
        
        book = ProductFactory.getProduct("book", "1", "book NO.1", 10, "good book NO.1");
        speaker = ProductFactory.getProduct("speaker", "2", "speaker NO.2", 20, "good speaker NO.2");
        
        book2 = ProductFactory.getProduct("book", "3", "book NO.3", 10, "good book NO.3");
        speaker2 = ProductFactory.getProduct("speaker", "4", "speaker NO.4", 20, "good speaker NO.4");
    }

    @Test
    public void testAddProduct() {
        catalog.addProduct(book);
        assertEquals(book, catalog.getProduct("1"));
    }

    @Test
    public void testRemoveProduct() {
        catalog.addProduct(book);
        catalog.removeProduct("1");  
        assertNull(catalog.getProduct("1"));
  }
    
    @Test
	void testRemoveProductException() {
		assertThrows(IllegalArgumentException.class, ()->catalog.removeProduct("1"), "nonexistent product ID");
		catalog.addProduct(book);
		assertThrows(IllegalArgumentException.class, ()->catalog.removeProduct("2"), "nonexistent product ID");
		catalog.addProduct(speaker);
		assertThrows(IllegalArgumentException.class, ()->catalog.removeProduct("3"), "nonexistent product ID");
		catalog.addProduct(book2);
		assertThrows(IllegalArgumentException.class, ()->catalog.removeProduct("4"), "nonexistent product ID");
		catalog.addProduct(speaker2);
		assertThrows(IllegalArgumentException.class, ()->catalog.removeProduct("5"), "nonexistent product ID");
	
    }
    @Test
    public void testGetProduct() {
        catalog.addProduct(book);
        Product retrievedProduct = catalog.getProduct("1");
        assertEquals(book, retrievedProduct);
    }
 
    

    @Test
    public void testGetAllProducts() {
        catalog.addProduct(book);
        catalog.addProduct(speaker);

        Collection<Product> allProducts = catalog.getAllProducts();
        assertTrue(allProducts.contains(book) && allProducts.contains(speaker));
        assertEquals(2, allProducts.size());
    }
}
