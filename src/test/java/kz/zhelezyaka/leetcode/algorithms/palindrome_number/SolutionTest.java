package kz.zhelezyaka.leetcode.algorithms.palindrome_number;

import org.junit.jupiter.api.Test;

import static kz.zhelezyaka.leetcode.palindrome_number_9.Solution.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void testPositivePalindromeEvenLength() {
        assertTrue(isPalindrome(1221));   // чётное количество цифр
        assertTrue(isPalindrome(3443));
        assertTrue(isPalindrome(9999));
    }

    @Test
    void testPositivePalindromeOddLength() {
        assertTrue(isPalindrome(121));    // нечётное количество цифр
        assertTrue(isPalindrome(12321));
        assertTrue(isPalindrome(7));       // одна цифра — всегда палиндром
        assertTrue(isPalindrome(0));       // ноль — палиндром!
    }

    @Test
    void testNotPalindrome() {
        assertFalse(isPalindrome(123));
        assertFalse(isPalindrome(100));
        assertFalse(isPalindrome(1234));
        assertFalse(isPalindrome(123456));
    }

    @Test
    void testEndsWithZeroButNotZero() {
        assertFalse(isPalindrome(10));
        assertFalse(isPalindrome(100));
        assertFalse(isPalindrome(1230));
        assertFalse(isPalindrome(1234567890));
    }

    @Test
    void testNegativeNumbers() {
        assertFalse(isPalindrome(-121));
        assertFalse(isPalindrome(-1));
        assertFalse(isPalindrome(-100));
    }

    @Test
    void testEdgeCasesFromConstraints() {
        assertFalse(isPalindrome(Integer.MIN_VALUE)); // -2147483648
        assertTrue(isPalindrome(1000000001)); // большой палиндром
    }

    @Test
    void testLargePalindromes() {
        assertTrue(isPalindrome(1000000001)); // 1_000_000_001 → палиндром
        assertTrue(isPalindrome(123454321));  // 123454321   → палиндром
        assertTrue(isPalindrome(111111111));  // 111111111   → палиндром
        assertTrue(isPalindrome(2147447412)); // большой палиндром (влезает в int!)
        assertFalse(isPalindrome(2147483647)); // MAX_VALUE — не палиндром
        assertFalse(isPalindrome(400650999));
    }

    @Test
    void testSingleDigitNumbers() {
        for (int i = 0; i <= 9; i++) {
            assertTrue(isPalindrome(i), "Число " + i + " должно быть палиндромом");
        }
    }

    @Test
    void testClassicLeetCodeExamples() {
        assertTrue(isPalindrome(121));
        assertFalse(isPalindrome(-121));
        assertFalse(isPalindrome(10));
    }
}