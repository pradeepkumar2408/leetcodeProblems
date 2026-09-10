class Pair{
    int a;
    int b;
    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : nums)
            mp.put(i , mp.getOrDefault(i, 0) + 1);
        
        int[] res = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(y.b, x.b));

        for(Map.Entry<Integer, Integer> i : mp.entrySet()){
            pq.add(new Pair(i.getKey(), i.getValue()));
        }
        int i = 0;
        while(k-- > 0){
            res[i++] = pq.poll().a;
        }
        return res;
    }
}