class Solution {
    void find(int index, List<Integer> ans, List<List<Integer>> res, int[] nums){
        if(index == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[index]);
        find(index + 1, ans,res,nums);
        ans.remove(ans.size() - 1);
        find(index + 1, ans, res, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        find(0,ans,res,nums);
        return res;
    }
}