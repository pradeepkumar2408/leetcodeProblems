class Solution {
    int dpCalculate(int j, int[] dp){
        if(j == 0)
            return 1;
        if(dp[j] != -1)
            return dp[j];
        int cost = 1;
        for(int i = 1; i <= j; i++)
            cost = Math.max(cost , i * dpCalculate(j - i, dp));
        return dp[j] = cost;
    }

    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dpCalculate(n, dp);
    }
}