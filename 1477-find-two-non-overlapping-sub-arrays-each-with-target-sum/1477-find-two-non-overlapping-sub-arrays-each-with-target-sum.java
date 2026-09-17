class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,(int) 1e9);
        int left = 0, sum = 0, res =(int) 1e9;
        for(int right = 0; right < n; right++){
            sum += arr[right];
            while(left <= right && sum > target){
                sum -= arr[left];
                left++;
            }
            if(sum == target){
                dp[right] = Math.min(dp[right], right - left + 1);
                if(left - 1 > 0 && dp[left - 1] != 1e9){
                    res = Math.min(res,dp[left - 1] + right - left + 1);
                }
            }
                if(right - 1 >= 0)
                dp[right] = Math.min(dp[right],dp[right - 1]);
        }
        return res == 1e9 ? -1: res;
    }
}