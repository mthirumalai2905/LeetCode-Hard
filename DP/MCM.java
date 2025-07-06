public class MatrixChainMultiplication {
    static int[][] dp;

    public static int matrixChainOrder(int[] arr) {
        int n = arr.length;
        dp = new int[n][n];

        // Initialize dp array with -1
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        return solve(arr, 1, n - 1);
    }

    private static int solve(int[] arr, int i, int j) {
        if (i >= j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, cost);
        }

        dp[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        System.out.println("Minimum multiplications: " + matrixChainOrder(arr));
    }
}
