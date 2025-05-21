package kz.zhelezyaka.leetcode.algorithms.set_matrix_zeroes_73;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Проверяем, есть ли нули в первой строке и первом столбце
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Проверяем первую строку
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Проверяем первый столбец
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Используем первую строку и столбец как маркеры
        // Проверяем остальную часть матрицы
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Помечаем первую ячейку строки
                    matrix[0][j] = 0; // Помечаем первую ячейку столбца
                }
            }
        }

        // Обнуляем строки на основе маркеров в первом столбце
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Обнуляем столбцы на основе маркеров в первой строке
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Обнуляем первую строку, если в ней был нуль
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Обнуляем первый столбец, если в нем был нуль
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}