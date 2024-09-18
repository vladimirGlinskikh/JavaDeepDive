package kz.zhelezyaka.leetcode.algorithms.longest_common_prefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testCommonPrefix() {
        // Тест с общим префиксом
        String[] strs = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefix(strs);
        assertEquals("fl", result);
    }

    @Test
    void testNoCommonPrefix() {
        // Тест без общего префикса
        String[] strs = {"dog", "racecar", "car"};
        String result = solution.longestCommonPrefix(strs);
        assertEquals("", result);
    }

    @Test
    void testIdenticalStrings() {
        // Тест с одинаковыми строками
        String[] strs = {"test", "test", "test"};
        String result = solution.longestCommonPrefix(strs);
        assertEquals("test", result);
    }

    @Test
    void testSingleString() {
        // Тест с одной строкой
        String[] strs = {"alone"};
        String result = solution.longestCommonPrefix(strs);
        assertEquals("alone", result);
    }

    @Test
    void testEmptyArray() {
        // Тест с пустым массивом
        String[] strs = {};
        String result = solution.longestCommonPrefix(strs);
        assertEquals("", result);
    }

    @Test
    void testEmptyStringInArray() {
        // Тест с пустой строкой в массиве
        String[] strs = {"", "test", "testing"};
        String result = solution.longestCommonPrefix(strs);
        assertEquals("", result);
    }

    @Test
    void testAllEmptyStrings() {
        // Тест с массивом из пустых строк
        String[] strs = {"", "", ""};
        String result = solution.longestCommonPrefix(strs);
        assertEquals("", result);
    }

    @Test
    void testOneCharacterStrings() {
        // Тест с односимвольными строками
        String[] strs = {"a", "a", "a"};
        String result = solution.longestCommonPrefix(strs);
        assertEquals("a", result);
    }

    @Test
    void testMixedCase() {
        // Тест с разными регистрами
        String[] strs = {"Test", "test", "Testing"};
        String result = solution.longestCommonPrefix(strs);
        assertEquals("", result);
    }

    @Test
    void testCommonPrefixFullString() {
        // Тест, где весь префикс — это одна из строк
        String[] strs = {"ab", "abc", "abcd"};
        String result = solution.longestCommonPrefix(strs);
        assertEquals("ab", result);
    }
}