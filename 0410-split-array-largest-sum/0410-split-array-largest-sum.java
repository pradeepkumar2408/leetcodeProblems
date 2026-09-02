class Solution {
    int check(int mid, int[] nums, int k){
        int cnt = 0, sum = 0, max = 0;
        for(int i : nums){
            if(sum + i > mid){
                sum = 0;
                cnt++;
            }
            sum += i;
            max = Math.max(max, sum);
        }
        cnt++;
        if(cnt <= k) return max;
        return -1;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for(int i : nums)
            high += i;

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int res = check(mid, nums, k);
            if(res != -1){
                ans = res;
                high = mid - 1;
            }else
                low = mid + 1;
        }
        return ans;
    }
}