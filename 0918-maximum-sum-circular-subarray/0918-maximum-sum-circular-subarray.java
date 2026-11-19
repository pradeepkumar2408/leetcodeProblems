class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = (int)-1e9, MaxSum = (int)-1e9, currMin = 0, MinSum = 0, total = 0;
        for(int num : nums){
            currMax = Math.max(num, currMax + num);
            MaxSum = Math.max(MaxSum, currMax);

            currMin = Math.min(num, currMin + num);
            MinSum = Math.min(MinSum, currMin);

            total += num;
        }
        int res = Math.max(total - MinSum, MaxSum);
        if(res <= 0)
        return MaxSum;
        return Math.max(total - MinSum, MaxSum);
    }
}