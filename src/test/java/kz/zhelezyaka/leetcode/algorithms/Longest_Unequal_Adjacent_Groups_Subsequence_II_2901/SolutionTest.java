package kz.zhelezyaka.leetcode.algorithms.Longest_Unequal_Adjacent_Groups_Subsequence_II_2901;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    // Вспомогательная функция для проверки условий подпоследовательности
    private void assertValidSubsequence(String[] words, int[] groups, List<String> result) {
        assertNotNull(result, "Result should not be null");
        if (result.isEmpty()) return;

        // Проверяем, что слова из результата присутствуют в words
        for (String word : result) {
            assertTrue(Arrays.asList(words).contains(word), "Result contains invalid word: " + word);
        }

        // Проверяем условия: разные группы, одинаковая длина, расстояние Хэмминга = 1
        for (int i = 1; i < result.size(); i++) {
            String currWord = result.get(i);
            String prevWord = result.get(i - 1);
            int currIdx = Arrays.asList(words).indexOf(currWord);
            int prevIdx = Arrays.asList(words).indexOf(prevWord);

            // Разные группы
            assertNotEquals(groups[currIdx], groups[prevIdx],
                    "Adjacent words should have different groups at indices " + prevIdx + " and " + currIdx);

            // Одинаковая длина
            assertEquals(currWord.length(), prevWord.length(),
                    "Adjacent words should have same length: " + prevWord + ", " + currWord);

            // Расстояние Хэмминга = 1
            int hammingDist = solution.hammingDistance(currWord, prevWord);
            assertEquals(1, hammingDist,
                    "Hamming distance should be 1 between " + prevWord + " and " + currWord);
        }
    }

    @Test
    public void testExample1() {
        String[] words = {"bab", "dab", "cab"};
        int[] groups = {1, 2, 2};
        List<String> result = solution.getWordsInLongestSubsequence(words, groups);

        // Проверяем длину результата (должна быть 2)
        assertEquals(2, result.size(), "Result length should be 2");

        // Проверяем, что результат валиден
        assertValidSubsequence(words, groups, result);

        // Проверяем возможные правильные ответы: ["bab","cab"] или ["bab","dab"]
        String[] expected1 = {"bab", "cab"};
        String[] expected2 = {"bab", "dab"};
        boolean isValid = result.equals(Arrays.asList(expected1)) || result.equals(Arrays.asList(expected2));
        assertTrue(isValid, "Result should be either [bab,cab] or [bab,dab], got: " + result);
    }

    @Test
    public void testExample2() {
        String[] words = {"a", "b", "c", "d"};
        int[] groups = {1, 2, 3, 4};
        List<String> result = solution.getWordsInLongestSubsequence(words, groups);

        // Проверяем длину результата (должна быть 4)
        assertEquals(4, result.size(), "Result length should be 4");

        // Проверяем, что результат валиден
        assertValidSubsequence(words, groups, result);

        // Проверяем ожидаемый результат: ["a","b","c","d"]
        List<String> expected = Arrays.asList("a", "b", "c", "d");
        assertEquals(expected, result, "Result should be [a,b,c,d], got: " + result);
    }

    @Test
    public void testSingleElement() {
        String[] words = {"abc"};
        int[] groups = {1};
        List<String> result = solution.getWordsInLongestSubsequence(words, groups);

        // Проверяем длину результата (должна быть 1)
        assertEquals(1, result.size(), "Result length should be 1");

        // Проверяем, что результат содержит единственный элемент
        assertEquals(List.of("abc"), result, "Result should be [abc], got: " + result);
    }

    @Test
    public void testSameGroups() {
        String[] words = {"abc", "def", "ghi"};
        int[] groups = {1, 1, 1};
        List<String> result = solution.getWordsInLongestSubsequence(words, groups);

        // Поскольку все группы одинаковы, подпоследовательность должна быть длины 1
        assertEquals(1, result.size(), "Result length should be 1 when all groups are same");

        // Проверяем, что результат содержит одно из слов
        assertTrue(Arrays.asList(words).contains(result.get(0)), "Result should contain one of the words");
    }

    @Test
    public void testNoValidSubsequence() {
        String[] words = {"abc", "abcd", "abcde"};
        int[] groups = {1, 2, 3};
        List<String> result = solution.getWordsInLongestSubsequence(words, groups);

        // Поскольку строки имеют разную длину, подпоследовательность должна быть длины 1
        assertEquals(1, result.size(), "Result length should be 1 when no valid subsequence is possible");

        // Проверяем, что результат содержит одно из слов
        assertTrue(Arrays.asList(words).contains(result.get(0)), "Result should contain one of the words");
    }

    @Test
    public void testHammingDistanceNotOne() {
        String[] words = {"abc", "def", "ghi"};
        int[] groups = {1, 2, 3};
        List<String> result = solution.getWordsInLongestSubsequence(words, groups);

        // Поскольку расстояние Хэмминга между любыми парами слов != 1, подпоследовательность должна быть длины 1
        assertEquals(1, result.size(), "Result length should be 1 when Hamming distance is not 1");

        // Проверяем, что результат содержит одно из слов
        assertTrue(Arrays.asList(words).contains(result.get(0)), "Result should contain one of the words");
    }
}