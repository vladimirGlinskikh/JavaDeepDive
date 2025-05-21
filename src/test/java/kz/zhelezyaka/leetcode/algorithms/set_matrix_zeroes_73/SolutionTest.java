package kz.zhelezyaka.leetcode.algorithms.set_matrix_zeroes_73;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void testExample1() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix,
                "Should correctly set row 1 and column 1 to zeros for matrix [[1,1,1],[1,0,1],[1,1,1]]");
    }

    @Test
    void testExample2() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] expected = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix,
                "Should correctly set rows 0 and columns 0,3 to zeros for matrix [[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
    }

    @Test
    void testNoZeros() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix,
                "Should not modify matrix with no zeros");
    }

    @Test
    void testAllZeros() {
        int[][] matrix = {{0, 0}, {0, 0}};
        int[][] expected = {{0, 0}, {0, 0}};
        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix,
                "Should keep all zeros for matrix with all zeros");
    }

    @Test
    void testSingleElementZero() {
        int[][] matrix = {{0}};
        int[][] expected = {{0}};
        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix,
                "Should handle 1x1 matrix with zero");
    }

    @Test
    void testSingleElementNonZero() {
        int[][] matrix = {{1}};
        int[][] expected = {{1}};
        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix,
                "Should handle 1x1 matrix with non-zero");
    }

    @Test
    void testSingleRowWithZero() {
        int[][] matrix = {{1, 0, 3}};
        int[][] expected = {{0, 0, 0}};
        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix,
                "Should set entire row to zeros for single row with zero");
    }

    @Test
    void testSingleColumnWithZero() {
        int[][] matrix = {{1}, {0}, {3}};
        int[][] expected = {{0}, {0}, {0}};
        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix,
                "Should set entire column to zeros for single column with zero");
    }

    @Test
    void testNullMatrix() {
        int[][] matrix = null;
        assertThrows(NullPointerException.class, () -> solution.setZeroes(matrix),
                "Should throw NullPointerException for null matrix");
    }
}