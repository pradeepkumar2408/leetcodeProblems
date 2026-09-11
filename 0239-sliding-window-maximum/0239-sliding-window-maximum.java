class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(y.first, x.first));

        for(int i = 0; i < k; i++)
            pq.add(new Pair(nums[i], i));

        int[] res = new int[nums.length - k + 1];
        int i = 0;
        res[i++] = pq.peek().first;
        for(int right = k; right < nums.length; right++){
            pq.add(new Pair(nums[right], right));
            while(pq.peek().second <= right - k){
                pq.poll();
            }
            res[i++] = pq.peek().first;
        }
        return res;
    }
}