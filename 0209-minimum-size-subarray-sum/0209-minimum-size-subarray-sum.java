class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, flag = 0;
        long sum = 0, min_size = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                if (min_size > right - left + 1) {
                    min_size = right - left + 1;
                    flag = 1;
                }
                sum -= nums[left];
                left++;
            }
            
        }
        if (flag == 1)
            return (int) min_size;
        return 0;
    }
}