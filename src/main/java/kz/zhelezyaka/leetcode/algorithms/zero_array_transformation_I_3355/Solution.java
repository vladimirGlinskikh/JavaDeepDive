package kz.zhelezyaka.leetcode.algorithms.zero_array_transformation_I_3355;

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        // Разностный массив для подсчета количества запросов для каждого индекса
        long[] diff = new long[n + 1];

        // Заполняем разностный массив
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            diff[left]++;
            if (right + 1 < n) {
                diff[right + 1]--;
            }
        }

        // Восстанавливаем количество запросов для каждого индекса
        long[] count = new long[n];
        count[0] = diff[0];
        for (int j = 1; j < n; j++) {
            count[j] = count[j - 1] + diff[j];
        }

        // Проверяем, достаточно ли уменьшений для каждого элемента
        for (int j = 0; j < n; j++) {
            if (count[j] < nums[j]) {
                return false;
            }
        }
        return true;
    }
}