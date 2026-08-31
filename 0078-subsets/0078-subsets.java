class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = (int)(Math.pow(2,nums.length));
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int k = 0; k < nums.length; k++){
                if((i & (1 << k)) != 0){
                    ans.add(nums[k]);
                }
            }
            res.add(ans);
        }
        return res;
    }
}