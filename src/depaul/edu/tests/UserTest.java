package depaul.edu.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import depaul.edu.cart.Cart;
import depaul.edu.models.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("testUser", "testPassword");
    }

    @Test
    void testConstructorAndGetter() {
        assertEquals("testUser", user.getUsername());
    }

    @Test
    void testCheckPassword() {
        assertTrue(user.checkPassword("testPassword"));
        assertFalse(user.checkPassword("wrongPassword"));
    }

    @Test
    void testGetCart() {
        assertNotNull(user.getCart());
        assertSame(Cart.getInstance(), user.getCart());
    }

    @Test
    void testToString() {
        String expectedString = "User{username='testUser', cart=" + user.getCart().toString() + '}';
        assertEquals(expectedString, user.toString());
    }
}
