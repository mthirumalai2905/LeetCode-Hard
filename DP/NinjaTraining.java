public class NinjaTrainingMemoization {
    public static int maxMeritPoints(int[][] points) {
        int n = points.length;
        int[][] memo = new int[n][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 4; j++)
                memo[i][j] = -1;
        return helper(n - 1, 3, points, memo);
    }

    private static int helper(int day, int last, int[][] points, int[][] memo) {
        if (day < 0) return 0;
        if (memo[day][last] != -1) return memo[day][last];
        int max = 0;
        for (int activity = 0; activity < 3; activity++) {
            if (activity != last) {
                int curr = points[day][activity] + helper(day - 1, activity, points, memo);
                if (curr > max) max = curr;
            }
        }
        memo[day][last] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] points = {
            {10, 50, 1},
            {5, 100, 11},
            {20, 30, 50},
            {40, 20, 70}
        };
        System.out.println(maxMeritPoints(points)); // Output: 151
    }
}
