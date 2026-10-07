class Solution {
    int mod = (int)1e9 + 7;
    int dpCalculate(int i , int end, int k, int[][] dp, int v){
        if(i == end && k == 0)
            return 1;
        if( k == 0 && i != end)
            return 0;
        if(dp[i + v][k] != -1)
            return dp[i + v][k];
        int ans = 0;
        ans =(ans + dpCalculate(i + 1, end, k - 1, dp, v)) % mod;
        ans =(ans + dpCalculate(i - 1, end, k - 1, dp, v)) % mod;
        return dp[i + v][k] = ans;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[(startPos + (2 * k)) + 1][k + 1];
        for(int i = 0; i < (startPos + (2 * k)) + 1; i++)
            Arrays.fill(dp[i], -1);
        return dpCalculate(startPos, endPos, k, dp, k);
    }
}