import java.util.Scanner;

public class RodCutting {

    public static int rodCutting(int[] prices, int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;

            for (int j = 1; j <= i; j++) {
                maxVal = Math.max(maxVal, prices[j - 1] + dp[i - j]);
            }

            dp[i] = maxVal;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int rodLength = sc.nextInt();
        System.out.println(rodCutting(prices, rodLength));
    }
}