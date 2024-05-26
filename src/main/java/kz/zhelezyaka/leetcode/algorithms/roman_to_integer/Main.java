package kz.zhelezyaka.leetcode.algorithms.roman_to_integer;

public class Main {

    public static int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            char nextChar = (i + 1 < length) ? s.charAt(i + 1) : ' ';

            result += switch (currentChar) {
                case 'I' -> (nextChar == 'V' || nextChar == 'X') ? -1 : 1;
                case 'V' -> 5;
                case 'X' -> (nextChar == 'L' || nextChar == 'C') ? -10 : 10;
                case 'L' -> 50;
                case 'C' -> (nextChar == 'D' || nextChar == 'M') ? -100 : 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> throw new IllegalArgumentException("Sorry this invalid Roman number");
            };
        }
        return result;
    }
}
