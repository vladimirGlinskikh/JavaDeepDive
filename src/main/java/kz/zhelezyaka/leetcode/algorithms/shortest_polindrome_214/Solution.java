package kz.zhelezyaka.leetcode.algorithms.shortest_polindrome_214;

public class Solution {
    public String shortestPalindrome(String s) {
        // Если строка пуста или уже палиндром, просто возвращаем её
        if (s == null || s.length() <= 1) {
            return s;
        }

        // Строим строку, которая является конкатенацией исходной строки и её реверса
        String reverse = new StringBuilder(s).reverse().toString();
        String concat = s + "#" + reverse;

        // Массив для хранения длин префиксов, которые совпадают с суффиксами
        int[] kmpTable = buildKMPTable(concat);

        // Находим длину самого длинного префикса, который является палиндромом
        int longestPrefixPalindromeLength = kmpTable[kmpTable.length - 1];

        // Добавляем недостающие символы из реверса строки к началу строки
        String toAdd = reverse.substring(0, reverse.length() - longestPrefixPalindromeLength);
        return toAdd + s;
    }

    // Построение KMP таблицы для эффективного поиска префиксов, совпадающих с суффиксами
    private int[] buildKMPTable(String s) {
        int n = s.length();
        int[] table = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = table[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            table[i] = j;
        }

        return table;
    }
}