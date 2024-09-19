package kz.zhelezyaka.leetcode.algorithms.different_ways_to_add_parentheses_241;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.isEmpty()) {
            return new ArrayList<>();  // Возвращаем пустой список для пустого выражения
        }

        List<Integer> result = new ArrayList<>();

        // Пройдем по каждому символу выражения
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Если это оператор, разделим выражение на две части
            if (c == '+' || c == '-' || c == '*') {
                // Разделяем строку на левую и правую части относительно текущего оператора
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // Теперь комбинируем результаты левой и правой частей с текущим оператором
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        // Если выражение — это просто число, добавляем его в результат
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}
