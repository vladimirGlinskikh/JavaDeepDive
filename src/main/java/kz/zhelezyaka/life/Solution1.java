package kz.zhelezyaka.life;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {2, 7, 11, 16};
        int target = 27;
        int[] result = solution.twoSum(nums, target);
        out.println("Output: [" + result[0] + ", " + result[1] + "]");
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
