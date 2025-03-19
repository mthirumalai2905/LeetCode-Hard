class Solution {
    private int[][] dp;
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    int longestIncreasingPath(int matrix[][], int n, int m) {
        dp = new int[n][m];
        int maxPath = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, n, m, -1));
            }
        }
        
        return maxPath;
    }
    
    private int dfs(int[][] matrix, int i, int j, int n, int m, int prevVal) {
        if (i < 0 || j < 0 || i >= n || j >= m || matrix[i][j] <= prevVal) {
            return 0;
        }
        
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        
        int mx = 0;
        for (int[] d : dir) {
            int newX = i + d[0];
            int newY = j + d[1];
            mx = Math.max(mx, dfs(matrix, newX, newY, n, m, matrix[i][j]));
        }
        
        return dp[i][j] = 1 + mx;
    }
}
