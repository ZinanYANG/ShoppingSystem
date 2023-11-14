package depaul.edu.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import depaul.edu.models.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("123", "Effective Java", 45.00, "A guide to Java programming");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("123", book.getId());
        assertEquals("Effective Java", book.getName());
        assertEquals(45.00, book.getPrice(), 0.001);
        assertEquals("A guide to Java programming", book.getDescription());
    }

    @Test
    void testSetters() {
        book.setId("124");
        assertEquals("124", book.getId());

        book.setName("Java Concurrency in Practice");
        assertEquals("Java Concurrency in Practice", book.getName());

        book.setPrice(55.00);
        assertEquals(55.00, book.getPrice(), 0.001);

        book.setDescription("Concurrency practices in Java");
        assertEquals("Concurrency practices in Java", book.getDescription());
    }

    @Test
    void testToString() {
        String expectedOutput = "Product ID: 123\n" +
                                "Name: Effective Java\n" +
                                "Price: $45.00\n" +
                                "Description: A guide to Java programming\n";
        assertEquals(expectedOutput, book.toString());
    }
}
