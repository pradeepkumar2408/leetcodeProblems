class Solution {
    int mod = (int)1e9 + 7;
    int dpCalculate(int i, int late, int absent, int n, int[][][] dp){
        if(absent >= 2 || late >= 3)
            return 0;
        if(i == n)
            return 1;
        if(dp[i][late][absent] != -1)
            return dp[i][late][absent];
        int ans = 0;
        ans =(ans + dpCalculate(i + 1, 0, absent, n, dp) )% mod;
        ans =(ans + dpCalculate(i + 1, late + 1, absent, n, dp) )% mod;
        ans =(ans + dpCalculate(i + 1, 0, absent + 1, n, dp) )% mod;

        return dp[i][late][absent] = ans % mod;
    }
    public int checkRecord(int n) {
        int[][][] dp = new int[n + 1][4][3];
        for(int i = 0; i <= n; i++)
            for(int j = 0; j < 4; j++)
                 Arrays.fill(dp[i][j], -1);
        return dpCalculate(0, 0, 0, n, dp);
    }
}