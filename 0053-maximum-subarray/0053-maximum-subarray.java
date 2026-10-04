class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], Curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(Curr < 0 ){
                Curr = 0;
            }
            Curr += nums[i];
            res = Math.max(Curr, res);
        }
        return res;
    }
}