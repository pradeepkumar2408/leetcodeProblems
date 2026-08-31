class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int one = 0, zero = 0;
            for(int num : nums){
                if((num & (1 << i)) != 0)
                    one++;
                else
                    zero++;
            }
            if(one == nums.length || zero == nums.length)
                continue;
            res += (one * zero);
        }
        return res;
    }
}