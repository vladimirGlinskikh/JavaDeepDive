package kz.zhelezyaka.life;

import java.util.Arrays;

import static java.lang.System.*;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = solution.lengthOfList(nums);
        out.println("Output: " + result);
    }

    public int lengthOfList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
