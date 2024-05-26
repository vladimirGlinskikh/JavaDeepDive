package kz.zhelezyaka.leetcode.roman_to_integer;

import kz.zhelezyaka.leetcode.algorithms.roman_to_integer.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    public void testSingleRomanNumerals() {
        assertEquals(1, Main.romanToInt("I"));
        assertEquals(5, Main.romanToInt("V"));
        assertEquals(10, Main.romanToInt("X"));
        assertEquals(50, Main.romanToInt("L"));
        assertEquals(100, Main.romanToInt("C"));
        assertEquals(500, Main.romanToInt("D"));
        assertEquals(1000, Main.romanToInt("M"));
    }

    @Test
    public void testSimpleRomanNumerals() {
        assertEquals(2, Main.romanToInt("II"));
        assertEquals(3, Main.romanToInt("III"));
        assertEquals(4, Main.romanToInt("IV"));
        assertEquals(6, Main.romanToInt("VI"));
        assertEquals(7, Main.romanToInt("VII"));
        assertEquals(8, Main.romanToInt("VIII"));
        assertEquals(9, Main.romanToInt("IX"));
        assertEquals(11, Main.romanToInt("XI"));
    }

    @Test
    public void testComplexRomanNumerals() {
        assertEquals(14, Main.romanToInt("XIV"));
        assertEquals(1994, Main.romanToInt("MCMXCIV"));
        assertEquals(19, Main.romanToInt("XIX"));
        assertEquals(40, Main.romanToInt("XL"));
        assertEquals(58, Main.romanToInt("LVIII"));
        assertEquals(90, Main.romanToInt("XC"));
        assertEquals(400, Main.romanToInt("CD"));
        assertEquals(3, Main.romanToInt("III"));
        assertEquals(900, Main.romanToInt("CM"));
        assertEquals(3999, Main.romanToInt("MMMCMXCIX"));
    }
}