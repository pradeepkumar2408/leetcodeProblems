class Solution {
    long dpCalculate(int i, int[][] questions, int n,long[] dp){
        if(i >= n)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        long ans = 0;
        ans = Math.max(ans , questions[i][0] + dpCalculate(i + questions[i][1] + 1, questions, n, dp));
        ans = Math.max(ans, dpCalculate(i + 1, questions, n, dp));
        return dp[i] = ans;
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return dpCalculate(0, questions, n, dp);
    }
}