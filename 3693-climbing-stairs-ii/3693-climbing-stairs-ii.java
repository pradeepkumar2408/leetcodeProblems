class Solution {
    int dpCalculate(int i, int n, int[] costs, int[] dp){
        if(i >= n)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        int ans = Integer.MAX_VALUE;
        if(i+1 <= n)
        ans = (int)(Math.min(ans, costs[i] + Math.pow(i + 1 - i, 2) + dpCalculate(i + 1, n, costs,dp)));
         if(i+2 <= n)
        ans = (int)(Math.min(ans, costs[i + 1] + Math.pow(i + 2 - i, 2) + dpCalculate(i + 2, n, costs, dp)));
         if(i+3 <= n)
        ans = (int)(Math.min(ans, costs[i + 2] + Math.pow(i + 3 - i, 2) + dpCalculate(i + 3, n, costs, dp)));
        return dp[i] = ans;
    }
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dpCalculate(0, n, costs, dp);
    } 
}