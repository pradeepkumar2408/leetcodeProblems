class Solution {
    int dpCalculate(int ind, int[] nums, int[] dp){
        if(ind >= nums.length)
            return 0;
        if(dp[ind] != -1)
            return dp[ind];
        int ans = 0;
        ans = Math.max(ans , nums[ind] + dpCalculate(ind + 2,nums,  dp));
        ans = Math.max(ans, dpCalculate(ind + 1, nums,  dp));
        return dp[ind] = ans;
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dpCalculate(0, nums, dp);
    }
}