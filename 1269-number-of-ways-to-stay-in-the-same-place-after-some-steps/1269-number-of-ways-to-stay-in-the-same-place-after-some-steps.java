class Solution {
    int mod = (int)1e9+7;
    int dpCalculate(int i , int steps, int arrLen, int[][] dp){
        if(i < 0 || i >= arrLen || (steps == 0 && i != 0))
            return 0;
        if(steps == 0 && i == 0)
            return 1;
        if(dp[i][steps] != -1)
            return dp[i][steps];
        int cnt = 0;
        cnt = (cnt + dpCalculate(i, steps - 1, arrLen, dp)) % mod;
        cnt = (cnt + dpCalculate(i + 1, steps - 1, arrLen, dp)) % mod;
        cnt = (cnt + dpCalculate(i - 1, steps - 1, arrLen, dp)) % mod;
        return dp[i][steps] = cnt;
    }
    public int numWays(int steps, int arrLen) {
        int[][] dp = new int[501][steps + 1];
        for(int i = 0; i < 501; i++)
            Arrays.fill(dp[i], -1);
        return dpCalculate(0, steps, arrLen, dp);
    }
}