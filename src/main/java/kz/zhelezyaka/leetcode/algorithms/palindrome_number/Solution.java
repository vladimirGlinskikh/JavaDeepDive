package kz.zhelezyaka.leetcode.algorithms.palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        // Отрицательные числа не являются палиндромами (из-за знака '-')
        if (x < 0) {
            return false;
        }
        
        // Числа, заканчивающиеся на 0 (кроме самого 0), не могут быть палиндромами
        // Например: 10, 100, 1230 → при развороте будет 01, 001, 0321 → то есть начинаться с 0
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        
        int reversed = 0;
        int original = x;
        
        // Разворачиваем только вторую половину числа
        while (x > reversed) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        
        // Для чётной длины: x == reversed
        // Для нечётной длины: x == reversed / 10 (средняя цифра остаётся в reversed)
        return x == reversed || x == reversed / 10;
    }
}