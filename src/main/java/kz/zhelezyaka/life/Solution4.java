package kz.zhelezyaka.life;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.*;

public class Solution4 {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int l = binarySearch(jobs, i);

            int inclProfit = jobs[i][2] + ((l > 0) ? dp[l - 1] : 0);
            int exclProfit = (i > 0) ? dp[i - 1] : 0;

            dp[i] = Math.max(inclProfit, exclProfit);
        }
        return dp[n - 1];
    }
    private static int binarySearch(int[][] jobs, int index) {
        int low = 0;
        int high = index - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid][1] <= jobs[index][0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};

        int result = jobScheduling(startTime, endTime, profit);
        out.println(result);
    }
}
