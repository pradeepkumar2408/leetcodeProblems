class Solution {
    boolean check(int mid, int[] position, int m){
        int prev = position[0], cnt = 1;
        for(int i = 1; i < position.length; i++){
            if(position[i] - prev >= mid){
                cnt++;
                prev = position[i];
            }
        }
        return cnt >= m;
    }
    public int maxDistance(int[] position, int m) {
        int low = 1, high = 0;
        for(int i : position)
            high = Math.max(high, i);
        int res = 0;
        Arrays.sort(position);
        while(low < high){
            int mid = low + (high - low) / 2;
            if(check(mid, position, m)){
                res = mid;
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return res;
    }
}