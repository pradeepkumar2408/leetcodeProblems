class Solution {
    boolean check(int mid, int[] nums, int threshold){
        int cnt = 0, sum = 0;
        for(int i : nums){
            sum += (int)(Math.ceil((double)i/mid));
            
        }
        return sum <= threshold;

    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        for(int i : nums)
            high = Math.max(high, i);
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(check(mid, nums, threshold)){
                ans = mid;
                high = mid - 1;
            }else
                low = mid + 1;
        }
        return ans;
    }
}