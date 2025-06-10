import java.util.*;

class Solution {
    public int minEnergy(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int energy = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    dp[i] = Math.min(dp[i], energy);
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] heights = {10, 5, 20, 0, 15};
        int k = 2;
        System.out.println(sol.minEnergy(heights, k)); // Output: 15
    }
}
