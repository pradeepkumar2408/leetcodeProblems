class Solution {
    void find(List<List<Integer>> res, List<Integer> ans, int index, int[] nums) {
        if (nums.length == index) {
            res.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[index]);
        find(res, ans, index + 1, nums);
        while (index + 1 < nums.length && nums[index] == nums[index + 1])
            index++;
        ans.remove(ans.size() - 1);
        find(res, ans, index + 1, nums);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        find(res, ans, 0, nums);
        return res;
    }
}