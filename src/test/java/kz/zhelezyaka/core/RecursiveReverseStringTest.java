package kz.zhelezyaka.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveReverseStringTest {
    private RecursiveReverseString string;

    @BeforeEach
    void setUp() {
        string = new RecursiveReverseString();
    }

    @Test
    void reverseString() {
        assertEquals("tupni",
                string.reverseString("input"));
        assertEquals("b",
                string.reverseString("b"));
        assertEquals("ffffff",
                string.reverseString("ffffff"));
        assertNotEquals("tupni",
                string.reverseString("tupni"));
        assertNotEquals("fff",
                string.reverseString("fffff"));
    }
}