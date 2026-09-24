class Solution {
    boolean check(int mid, int[] citations){
        int cnt = 0;
        for(int i : citations){
            if(i >= mid)
                cnt++;
        }
        return cnt >= mid;
    }
    public int hIndex(int[] citations) {
        int low = 1, high = 1;
        for(int i : citations)
            high = Math.max(high, i);
        
        int res = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(check(mid, citations)){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }
}