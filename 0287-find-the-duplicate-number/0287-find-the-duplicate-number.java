class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++)
            if((nums[i] ^ nums[i + 1]) == 0)
                return nums[i];
        return nums.length;
    }
}