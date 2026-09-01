class Solution {
    boolean check(int mid, int[] bloomDay, int m, int k){
        int cnt = 0, res = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                cnt++;
                if(cnt == k){
                    res++;
                    cnt = 0;
                }
            }else{
                cnt = 0;
            }
        }
        return res >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length)
            return -1;

        int low = 1, high = 0;
        for(int i : bloomDay){
            high = Math.max(high, i);
        }
        
        while(low < high){
            int mid = low + (high - low) / 2;
            if(check(mid, bloomDay, m, k)){
                high = mid;
            }else
                low = mid + 1;
        }
        return low;
    }
}