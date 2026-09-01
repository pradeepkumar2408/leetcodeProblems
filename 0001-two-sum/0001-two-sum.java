class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] res= new int[2];
        for(int i = 0; i < nums.length; i++){
            int val = target - nums[i];
            
            if (mp.containsKey(val)) {
                return new int[]{mp.get(val), i};
            }

            mp.put(nums[i], i);
        }

        return new int[]{};
    }
}