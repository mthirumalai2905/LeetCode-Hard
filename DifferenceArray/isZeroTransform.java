public class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // difference array for range additions

        // Apply each query as a range increment of 1
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }

        int[] freq = new int[n];
        freq[0] = diff[0];
        for (int i = 1; i < n; i++) {
            freq[i] = freq[i - 1] + diff[i];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > freq[i]) {
                return false;
            }
        }

        return true;
    }
}
