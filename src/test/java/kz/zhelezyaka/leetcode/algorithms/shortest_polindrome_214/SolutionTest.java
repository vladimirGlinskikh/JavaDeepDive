package kz.zhelezyaka.leetcode.algorithms.shortest_polindrome_214;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void testExample1() {
        String input = "aacecaaa";
        String expected = "aaacecaaa";
        String result = solution.shortestPalindrome(input);
        assertEquals(expected, result);
    }

    @Test
    void testExample2() {
        String input = "abcd";
        String expected = "dcbabcd";
        String result = solution.shortestPalindrome(input);
        assertEquals(expected, result);
    }

    @Test
    void testEmptyString() {
        String input = "";
        String expected = "";
        String result = solution.shortestPalindrome(input);
        assertEquals(expected, result);
    }

    @Test
    void testSingleCharacter() {
        String input = "a";
        String expected = "a";
        String result = solution.shortestPalindrome(input);
        assertEquals(expected, result);
    }

    @Test
    void testAlreadyPalindrome() {
        String input = "racecar";
        String expected = "racecar";
        String result = solution.shortestPalindrome(input);
        assertEquals(expected, result);
    }

    @Test
    void testNoPalindromePrefix() {
        String input = "xyz";
        String expected = "zyxyz";
        String result = solution.shortestPalindrome(input);
        assertEquals(expected, result);
    }

    @Test
    void testLongPalindromePrefix() {
        String input = "aabba";
        String expected = "abbaabba";
        String result = solution.shortestPalindrome(input);
        assertEquals(expected, result);
    }
}