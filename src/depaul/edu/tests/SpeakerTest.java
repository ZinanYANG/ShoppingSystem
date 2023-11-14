package depaul.edu.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import depaul.edu.models.Speaker;

import static org.junit.jupiter.api.Assertions.*;

class SpeakerTest {

    private Speaker speaker;

    @BeforeEach
    void setUp() {
        speaker = new Speaker("200", "Bluetooth Speaker", 99.99, "High-quality sound and bass");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("200", speaker.getId());
        assertEquals("Bluetooth Speaker", speaker.getName());
        assertEquals(99.99, speaker.getPrice(), 0.001);
        assertEquals("High-quality sound and bass", speaker.getDescription());
    }

    @Test
    void testSetters() {
        speaker.setId("201");
        assertEquals("201", speaker.getId());

        speaker.setName("Wireless Speaker");
        assertEquals("Wireless Speaker", speaker.getName());

        speaker.setPrice(109.99);
        assertEquals(109.99, speaker.getPrice(), 0.001);

        speaker.setDescription("Superior sound quality");
        assertEquals("Superior sound quality", speaker.getDescription());
    }

    @Test
    void testToString() {
        String expectedOutput = "Product ID: 200\n" +
                                "Name: Bluetooth Speaker\n" +
                                "Price: $99.99\n" +
                                "Description: High-quality sound and bass\n";
        assertEquals(expectedOutput, speaker.toString());
    }
}
