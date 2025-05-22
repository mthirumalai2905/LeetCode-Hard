import java.util.*;

public class MinDeletionsPalindrome {
    public static int minDeletions(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        int lps = longestPalindrome(0, n - 1, s, memo);
        return n - lps;
    }

    private static int longestPalindrome(int i, int j, String s, int[][] memo) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (memo[i][j] != -1) return memo[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = 2 + longestPalindrome(i + 1, j - 1, s, memo);
        } else {
            int left = longestPalindrome(i + 1, j, s, memo);
            int right = longestPalindrome(i, j - 1, s, memo);
            memo[i][j] = Math.max(left, right);
        }

        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("aebcbda"));        // Output: 2
        System.out.println(minDeletions("geeksforgeeks"));  // Output: 8
    }
}
