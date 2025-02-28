class Solution {
    private Boolean[][] dp;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        dp = new Boolean[n][n];
        if(stones[1] != 1) return false;
        return solve(stones, 0, 0);
    }
    private boolean solve(int[] stones, int pos, int jump){
        if(pos == stones.length - 1) return true;
        if(dp[pos][jump] != null) return dp[pos][jump];

        for(int i = pos+1; i < stones.length; i++){
            int gap = stones[i] - stones[pos];
            if(gap < jump - 1) continue;
            if(gap > jump + 1) break;
            if(solve(stones, i, gap)){
                return dp[pos][jump] = true;
            }
        }

        return dp[pos][jump] = false;
    }
}
