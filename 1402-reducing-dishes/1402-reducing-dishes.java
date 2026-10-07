class Solution {
    int dpCalculate(int i, int[] satisfaction, int time, int[][] dp){
        if(i >= satisfaction.length)
            return 0;
        if(dp[i][time] != -1)
            return dp[i][time];
        int ans = 0;
        ans = dpCalculate(i + 1, satisfaction, time, dp);
        ans = Math.max(ans,(satisfaction[i] * time) + dpCalculate(i + 1, satisfaction, time + 1, dp));
        return dp[i][time] = ans;
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length][satisfaction.length + 1];
        for(int i = 0; i < satisfaction.length; i++)
            Arrays.fill(dp[i] , -1);
        int res = dpCalculate(0, satisfaction, 1, dp);
        return res < 0 ? 0 : res;
    }
}