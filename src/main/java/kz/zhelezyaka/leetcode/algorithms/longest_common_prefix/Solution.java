package kz.zhelezyaka.leetcode.algorithms.longest_common_prefix;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Найдем минимальную длину строки, чтобы не проверять больше символов, чем есть
        int minLength = Arrays.stream(strs)
                .mapToInt(String::length)
                .min()
                .orElse(0);

        // Найдем индекс, до которого все строки совпадают
        int prefixLength = (int) IntStream.range(0, minLength)
                .filter(i -> Arrays.stream(strs)
                        .map(s -> s.charAt(i)).distinct().count() > 1)
                .findFirst()
                .orElse(minLength);

        return strs[0].substring(0, prefixLength);
    }
}

