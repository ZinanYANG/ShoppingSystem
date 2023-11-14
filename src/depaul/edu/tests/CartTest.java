package depaul.edu.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import depaul.edu.cart.Cart;
import depaul.edu.models.Book;
import depaul.edu.models.Product;
import depaul.edu.models.Speaker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

class CartTest {

    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = Cart.getInstance();
        cart.clearCart();

        product1 = new Book("1", "Effective Java", 45.00, "Effective Java by Joshua Bloch");
        product2 = new Speaker("2", "Bluetooth Speaker", 25.00, "Portable Bluetooth Speaker");
    }

    @Test
    public void testAddItem() {
        cart.addItem(product1);
        assertEquals(1, cart.getQuantity(), "Cart should have 1 item after adding a product");// Clear the cart after test to ensure no side effects for other tests
    }
    
    @Test
    public void testRemoveItem() {
        cart.addItem(product2);
        cart.removeItem(product2);
        assertEquals(0, cart.getQuantity(), "Cart should have 0 items after removing the product");
    }
    
    @Test
    public void testGetQuantity() {
        for(int i = 0; i<10; i++) {
            cart.addItem(product2);
        }
        assertEquals(10, cart.getQuantity(), "Cart should have 0 items after removing the product");
    }
    
    @Test
    public void testClearCart() {
        for(int i = 0; i<10; i++) {
            cart.addItem(product2);
        }
        cart.clearCart();
        assertEquals(0, cart.getQuantity(), "Cart should have 0 items after removing the product");
    }
    
    @Test
    public void testGetTotal() {
        for(int i = 0; i<10; i++) {
            cart.addItem(product1);
        }
        for(int i = 0; i<10; i++) {;
            cart.addItem(product2);
        }

        assertEquals(700, cart.getTotal(), "Cart should have 0 items after removing the product");
    }
    
    @Test
    public void testGetItems() {
        cart.addItem(product1);
        cart.addItem(product2);
        List<Product> items = cart.getItems();

        assertTrue("Cart should contain product1", items.contains(product1));
        assertTrue("Cart should contain product2", items.contains(product2));
        assertEquals("Cart should have 2 items", 2, items.size());
    }
    
    
    
    
    
    
}
