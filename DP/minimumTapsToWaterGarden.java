class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i <= n; i++){
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);

            for(int j = left; j <= right; j++){
             if(dp[left] != Integer.MAX_VALUE){
                dp[j] = Math.min(dp[j], dp[left] + 1);
             }   
            }
        }

        return dp[n] == Integer.MAX_VALUE ? - 1 : dp[n];
    }
}
