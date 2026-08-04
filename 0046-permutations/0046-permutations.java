class Solution {
    void find(List<Integer> ans,  List<List<Integer>> res, int n, boolean[] vis, int[] nums){
        if(ans.size() == n){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0; i < n ; i++){
            if(!vis[i]){
                vis[i] = true;
                ans.add(nums[i]);
                find(ans,res,n,vis,nums);

                vis[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
        
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] vis = new boolean[n];

        find(ans,res,n,vis,nums);
        return res;
    }
}