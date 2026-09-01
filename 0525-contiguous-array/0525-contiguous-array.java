class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0, res = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                sum += -1;
            }else
                sum += 1;
            if(sum == 0)
                res = i + 1;
            else if(mp.containsKey(sum)){
                res = Math.max(res, i - mp.get(sum));
            }else{
                mp.put(sum, i);
            }
        }
        return res;
    }
}