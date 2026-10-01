class Solution {
    int dpCalculate(int i , int amount, int[] coins, int[][] dp){
        if(i >= coins.length || amount < 0)
            return 0;
        if(amount == 0)
            return 1;
        if(dp[i][amount] != -1)
            return dp[i][amount];
        int cnt = 0;
        cnt = cnt + dpCalculate(i, amount - coins[i], coins, dp);
        cnt = cnt + dpCalculate(i + 1, amount, coins, dp);
        return dp[i][amount] = cnt;
    }
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int[][] dp = new int[m][amount + 1];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        return dpCalculate(0, amount, coins, dp);
    }
}