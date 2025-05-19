package kz.zhelezyaka.leetcode.algorithms.type_of_triangle_3024;

class Solution {
    public String triangleType(int[] nums) {
        // Проверяем, что все стороны положительны
        if (nums[0] <= 0 || nums[1] <= 0 || nums[2] <= 0) {
            return "none";
        }

        // Проверяем неравенство треугольника
        if (nums[0] + nums[1] <= nums[2] ||
                nums[0] + nums[2] <= nums[1] ||
                nums[1] + nums[2] <= nums[0]) {
            return "none";
        }

        // Проверяем тип треугольника
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}