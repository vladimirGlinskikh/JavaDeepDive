package kz.zhelezyaka.leetcode.algorithms.zero_array_transformation_I_3355;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void testExample1() {
        int[] nums = {1, 0, 1};
        int[][] queries = {{0, 2}};
        assertTrue(solution.isZeroArray(nums, queries),
                "Should return true for nums=[1,0,1], queries=[[0,2]]");
    }

    @Test
    void testExample2() {
        int[] nums = {4, 3, 2, 1};
        int[][] queries = {{1, 3}, {0, 2}};
        assertFalse(solution.isZeroArray(nums, queries),
                "Should return false for nums=[4,3,2,1], queries=[[1,3],[0,2]]");
    }

    @Test
    void testEmptyQueries() {
        int[] nums = {0, 0, 0};
        int[][] queries = {};
        assertTrue(solution.isZeroArray(nums, queries),
                "Should return true for nums=[0,0,0] with no queries");
    }

    @Test
    void testNonZeroWithEmptyQueries() {
        int[] nums = {1, 0, 1};
        int[][] queries = {};
        assertFalse(solution.isZeroArray(nums, queries),
                "Should return false for nums=[1,0,1] with no queries");
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {2};
        int[][] queries = {{0, 0}, {0, 0}};
        assertTrue(solution.isZeroArray(nums, queries),
                "Should return true for nums=[2], queries=[[0,0],[0,0]]");
    }

    @Test
    void testMultipleQueriesForSameIndex() {
        int[] nums = {3, 1, 1};
        int[][] queries = {{0, 1}, {0, 2}, {0, 0}};
        assertTrue(solution.isZeroArray(nums, queries),
                "Should return true for nums=[3,1,1], queries=[[0,1],[0,2],[0,0]]");
    }

    @Test
    void testBoundaryIndices() {
        int[] nums = {1, 1, 1, 1};
        int[][] queries = {{0, 0}, {1, 1}, {2, 2}, {3, 3}};
        assertTrue(solution.isZeroArray(nums, queries),
                "Should return true for nums=[1,1,1,1], queries=[[0,0],[1,1],[2,2],[3,3]]");
    }

    @Test
    void testInsufficientQueries() {
        int[] nums = {2, 2, 2};
        int[][] queries = {{0, 1}, {1, 2}};
        assertFalse(solution.isZeroArray(nums, queries),
                "Should return false for nums=[2,2,2], queries=[[0,1],[1,2]]");
    }

    @Test
    void testNullNums() {
        int[][] queries = {{0, 1}};
        assertThrows(NullPointerException.class, () -> solution.isZeroArray(null, queries),
                "Should throw NullPointerException for null nums");
    }

    @Test
    void testNullQueries() {
        int[] nums = {1, 1};
        assertThrows(NullPointerException.class, () -> solution.isZeroArray(nums, null),
                "Should throw NullPointerException for null queries");
    }
}