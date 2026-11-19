class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currMax = 0, MaxSum = 0, currMin = 0, MinSum = 0;
        for(int num : nums){
            currMax = Math.max(num, currMax + num);
            MaxSum = Math.max(MaxSum, currMax);

            currMin = Math.min(num, currMin + num);
            MinSum = Math.min(MinSum, currMin); 
        }
        return Math.max(MaxSum , Math.abs(MinSum));
    }
}