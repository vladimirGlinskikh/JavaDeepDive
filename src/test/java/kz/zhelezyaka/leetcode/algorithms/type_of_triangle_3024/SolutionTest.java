package kz.zhelezyaka.leetcode.algorithms.type_of_triangle_3024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testEquilateralTriangle() {
        int[] nums = {3, 3, 3};
        assertEquals("equilateral", solution.triangleType(nums),
                "Should return 'equilateral' for sides [3,3,3]");
    }

    @Test
    void testIsoscelesTriangleTwoEqualSides1() {
        int[] nums = {2, 2, 3};
        assertEquals("isosceles", solution.triangleType(nums),
                "Should return 'isosceles' for sides [2,2,3]");
    }

    @Test
    void testIsoscelesTriangleTwoEqualSides2() {
        int[] nums = {2, 3, 2};
        assertEquals("isosceles", solution.triangleType(nums),
                "Should return 'isosceles' for sides [2,3,2]");
    }

    @Test
    void testIsoscelesTriangleTwoEqualSides3() {
        int[] nums = {3, 2, 2};
        assertEquals("isosceles", solution.triangleType(nums),
                "Should return 'isosceles' for sides [3,2,2]");
    }

    @Test
    void testScaleneTriangle() {
        int[] nums = {3, 4, 5};
        assertEquals("scalene", solution.triangleType(nums),
                "Should return 'scalene' for sides [3,4,5]");
    }

    @Test
    void testInvalidTriangleNonPositiveSide() {
        int[] nums = {0, 1, 1};
        assertEquals("none", solution.triangleType(nums),
                "Should return 'none' for sides [0,1,1]");
    }

    @Test
    void testInvalidTriangleNegativeSide() {
        int[] nums = {-1, 2, 2};
        assertEquals("none", solution.triangleType(nums),
                "Should return 'none' for sides [-1,2,2]");
    }

    @Test
    void testInvalidTriangleInequality1() {
        int[] nums = {1, 1, 3};
        assertEquals("none", solution.triangleType(nums),
                "Should return 'none' for sides [1,1,3]");
    }

    @Test
    void testInvalidTriangleInequality2() {
        int[] nums = {2, 3, 6};
        assertEquals("none", solution.triangleType(nums),
                "Should return 'none' for sides [2,3,6]");
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> solution.triangleType(null),
                "Should throw NullPointerException for null input");
    }
}