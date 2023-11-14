package depaul.edu.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import depaul.edu.cart.Cart;
import depaul.edu.cart.CartBuilder;
import depaul.edu.catalog.ProductCatalog;
import depaul.edu.models.Book;
import depaul.edu.models.Speaker;
import depaul.edu.models.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CartBuilderTest {
	private CartBuilder cartBuilder;
    private ProductCatalog catalog;
    private User user;
    
	@BeforeEach
	public void setUp() {
		catalog = new ProductCatalog();
		user = new User("testUser", "testPassword");
		cartBuilder = new CartBuilder(catalog).setUser(user);
		// Add products to the catalog for testing
		catalog.addProduct(new Book("1", "Effective Java", 45.00, "Effective Java by Joshua Bloch"));
		catalog.addProduct(new Speaker("2", "Bluetooth Speaker", 25.00, "Portable Bluetooth Speaker"));
	}
	
	@Test
    public void testAddProduct() {
        cartBuilder.addProduct("1");
        assertEquals("add product id == 1", 1, cartBuilder.finalizeCart().getQuantity());
        cartBuilder.addProduct("1");
        assertEquals("add product id == 1", 2, cartBuilder.finalizeCart().getQuantity());

	}
	
	
	@Test
	void testAddProductException() {
		assertThrows(IllegalArgumentException.class, ()->cartBuilder.addProduct("000"), "nonexistent product ID");
		assertThrows(IllegalArgumentException.class, ()->cartBuilder.addProduct("00"), "nonexistent product ID");
		assertThrows(IllegalArgumentException.class, ()->cartBuilder.addProduct("0"), "nonexistent product ID");
		assertThrows(IllegalArgumentException.class, ()->cartBuilder.addProduct("nonexistent_id"), "nonexistent product ID");
	}
	
	@Test
    public void testRemoveProduct() {
        cartBuilder.addProduct("1");
        cartBuilder.removeProduct("1");
        assertEquals("remove product id == 1", 0, cartBuilder.finalizeCart().getQuantity());
    }
	
	
	@Test
	void testRemoveProductException() {
		assertThrows(IllegalArgumentException.class, ()->cartBuilder.removeProduct("0"), "nonexistent product ID");
		assertThrows(IllegalArgumentException.class, ()->cartBuilder.removeProduct("1"), "nonexistent product ID");
		assertThrows(IllegalArgumentException.class, ()->cartBuilder.removeProduct("2"), "nonexistent product ID");
		assertThrows(IllegalArgumentException.class, ()->cartBuilder.removeProduct("3"), "nonexistent product ID");
	}
	
	@Test
	public void testFinalizeCart() {
	    Cart finalizedCart = cartBuilder.finalizeCart();
	    assertNotNull(finalizedCart);
	    assertSame(Cart.getInstance(), finalizedCart);
	}

	
	
	
	

	
	
	
	
	

}
