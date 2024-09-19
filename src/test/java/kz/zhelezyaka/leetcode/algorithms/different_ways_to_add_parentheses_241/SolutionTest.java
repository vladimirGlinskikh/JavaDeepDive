package kz.zhelezyaka.leetcode.algorithms.different_ways_to_add_parentheses_241;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void testSimpleExpression1() {
        String expression = "2-1-1";
        List<Integer> result = solution.diffWaysToCompute(expression);
        List<Integer> expected = List.of(0, 2); // ((2-1)-1) = 0, (2-(1-1)) = 2
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testSimpleExpression2() {
        String expression = "2*3-4*5";
        List<Integer> result = solution.diffWaysToCompute(expression);
        List<Integer> expected = List.of(-34, -14, -10, -10, 10);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testSingleNumber() {
        String expression = "5";
        List<Integer> result = solution.diffWaysToCompute(expression);
        List<Integer> expected = List.of(5);
        assertEquals(expected, result);
    }

    @Test
    void testOnlyAddition() {
        String expression = "2+3+4";
        List<Integer> result = solution.diffWaysToCompute(expression);
        List<Integer> expected = List.of(9, 9); // (2+(3+4)) = 9, ((2+3)+4) = 9
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testOnlyMultiplication() {
        String expression = "2*3*4";
        List<Integer> result = solution.diffWaysToCompute(expression);
        List<Integer> expected = List.of(24, 24); // (2*(3*4)) = 24, ((2*3)*4) = 24
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testExpressionWithMultipleOperators() {
        String expression = "2*3-4+5";
        List<Integer> result = solution.diffWaysToCompute(expression);
        List<Integer> expected = List.of(-12, 8, -3, 3, 7);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testNegativeResults() {
        String expression = "5-10+2";
        List<Integer> result = solution.diffWaysToCompute(expression);
        List<Integer> expected = List.of(-3, -7); // (5-(10+2)) = -7, ((5-10)+2) = -3
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testExpressionWithSameOperator() {
        String expression = "4-3-2-1";
        List<Integer> result = solution.diffWaysToCompute(expression);
        List<Integer> expected = List.of(2, 0, 2, 4, -2);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testEmptyExpression() {
        String expression = "";
        List<Integer> result = solution.diffWaysToCompute(expression);
        assertTrue(result.isEmpty());
    }

    @Test
    void testComplexExpression() {
        String expression = "10*2-5+3*4";
        List<Integer> result = solution.diffWaysToCompute(expression);
        List<Integer> expected = List.of(-150, -300, 90, -240, 0, 3, -12, -18, 27, -240, 0, 48, -108, 72);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }
}