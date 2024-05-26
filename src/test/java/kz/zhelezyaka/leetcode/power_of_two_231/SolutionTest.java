package kz.zhelezyaka.leetcode.power_of_two_231;

import kz.zhelezyaka.leetcode.algorithms.power_of_two_231.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testPowerOfTwo() {
        assertTrue(solution.isPowerOfTwo(1));
        assertTrue(solution.isPowerOfTwo(2));
        assertTrue(solution.isPowerOfTwo(4));
        assertTrue(solution.isPowerOfTwo(8));
        assertTrue(solution.isPowerOfTwo(16));
        assertTrue(solution.isPowerOfTwo(32));
    }

    @Test
    void testNotPowerOfTwo() {
        Solution solution = new Solution();
        assertFalse(solution.isPowerOfTwo(0));
        assertFalse(solution.isPowerOfTwo(3));
        assertFalse(solution.isPowerOfTwo(5));
        assertFalse(solution.isPowerOfTwo(6));
        assertFalse(solution.isPowerOfTwo(7));
        assertFalse(solution.isPowerOfTwo(9));
    }
}