class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int pos = Collections.binarySearch(res,nums[i]);
            if (pos < 0)
                pos = -(pos + 1); 
            if(pos == res.size())
                res.add(nums[i]);
            else
                res.set(pos,nums[i]);
        }
        return res.size();
    }
}