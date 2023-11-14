package depaul.edu.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import depaul.edu.authentication.Authenticator;
import depaul.edu.models.User;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatorTest {

    private Authenticator authenticator;
    private User validUser;

    @BeforeEach
    void setUp() {
        authenticator = new Authenticator();
        validUser = new User("validUsername", "validPassword");
        authenticator.setUser(validUser);
    }

    @Test
    void testLoginSuccess() {
        assertTrue(authenticator.login("validUsername", "validPassword"));
        assertTrue(authenticator.isLoggedIn());
    }

    @Test
    void testLoginFailure() {
        assertFalse(authenticator.login("validUsername", "wrongPassword"));
        assertFalse(authenticator.isLoggedIn());
    }

    @Test
    void testLogout() {
        authenticator.login("validUsername", "validPassword");
        authenticator.logout();
        assertFalse(authenticator.isLoggedIn());
    }
}
