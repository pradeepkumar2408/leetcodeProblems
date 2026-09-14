class Solution {
    public int longestOnes(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int left = 0, res = 0, maxFreq = 0;
        for(int right = 0; right < nums.length; right++){
            mp.put(nums[right], mp.getOrDefault(nums[right], 0) + 1);
            if(nums[right] == 1)
            maxFreq = Math.max(maxFreq, mp.get(nums[right]));

            while((right - left + 1) - maxFreq > k){
                mp.put(nums[left],mp.get(nums[left]) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}