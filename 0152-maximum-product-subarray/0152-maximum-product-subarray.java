class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int oldmax = max, oldmin = min;

            max = Math.max(nums[i], Math.max(oldmax * nums[i], oldmin * nums[i]));
            min = Math.min(nums[i], Math.min(oldmax * nums[i], oldmin * nums[i]));

            res = Math.max(res,max);
        }
        return res;
    }
}