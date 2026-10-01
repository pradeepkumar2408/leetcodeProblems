class Solution {
    int dpCalculate(int i, int[] coins, int amount, int[][] dp){
        if(i >= coins.length || amount < 0)
            return (int)1e9;
        if(amount == 0)
            return 0;
        
        if(dp[i][amount] != -1)
            return dp[i][amount];
        int cnt = (int)1e9;
        cnt = Math.min(cnt, 1 + dpCalculate(i, coins, amount - coins[i], dp));
        cnt = Math.min(cnt, dpCalculate(i + 1, coins, amount, dp));
        return dp[i][amount] = cnt;
    }
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m][amount + 1];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        int res = dpCalculate(0, coins, amount, dp);
        return res == (int)1e9 ? -1 :res;
    }
}