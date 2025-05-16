package kz.zhelezyaka.leetcode.algorithms.Longest_Unequal_Adjacent_Groups_Subsequence_II_2901;

import java.util.*;

public class Solution {
    // Функция для вычисления расстояния Хэмминга
    int hammingDistance(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return -1;
        int dist = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) dist++;
        }
        return dist;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        // dp[i] - длина самой длинной подпоследовательности, заканчивающейся на индексе i
        int[] dp = new int[n];
        // parent[i] - предыдущий индекс в подпоследовательности, заканчивающейся на i
        int[] parent = new int[n];

        // Инициализация
        Arrays.fill(dp, 1); // Каждый индекс сам по себе - подпоследовательность длины 1
        Arrays.fill(parent, -1); // Нет предыдущего индекса

        // Заполнение dp
        int maxLen = 1, endIdx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Проверяем условия:
                // 1. Разные группы
                // 2. Одинаковая длина строк
                // 3. Расстояние Хэмминга = 1
                if (groups[i] != groups[j] &&
                        words[i].length() == words[j].length() &&
                        hammingDistance(words[i], words[j]) == 1) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            // Обновляем максимальную длину и конечный индекс
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIdx = i;
            }
        }

        // Восстанавливаем подпоследовательность
        List<String> result = new ArrayList<>();
        int curr = endIdx;
        while (curr != -1) {
            result.add(words[curr]);
            curr = parent[curr];
        }

        // Переворачиваем результат, так как добавляли с конца
        Collections.reverse(result);
        return result;
    }
}