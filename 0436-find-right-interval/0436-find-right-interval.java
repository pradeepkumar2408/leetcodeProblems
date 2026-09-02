class Solution {
    int search(int target, int low, int high, int[] arr){
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(target <= arr[mid]){
                ans = mid;
                high = mid - 1;
            }else
                low = mid + 1;
        }
        return ans;
    }
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] arr = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            mp.put(intervals[i][0], i);
            arr[i] = intervals[i][0];
        }
        Arrays.sort(arr);

        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            int val = search(intervals[i][1],0, intervals.length - 1, arr);
            if(val >= 0)
            res[i] = mp.get(arr[val]);
            else
            res[i] = val;
        }
        return res;
    }
}