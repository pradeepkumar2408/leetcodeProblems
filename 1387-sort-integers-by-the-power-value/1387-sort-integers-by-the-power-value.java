class Solution {
    int dpCalculate(int i, Map<Integer, Integer> mp){
        if(i == 1)
            return 1;
        if(mp.containsKey(i))
            return mp.get(i);
        int ans = 0;
        if(i % 2 == 0)
        ans += 1 + dpCalculate(i/2, mp);
        else
        ans += 1 + dpCalculate((3 * i) + 1, mp);
        mp.put(i, ans);
        return ans;
    }
    public int getKth(int lo, int hi, int k) {
        int[][] res = new int[hi - lo + 1][2];
        int j = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = lo; i <= hi; i++){
            int ans = dpCalculate(i, mp);
            res[j][0] = i;
            res[j][1] = ans;
            j++;
        }
        Arrays.sort(res, Comparator.comparingInt((int[] a) -> a[1])
                                      .thenComparingInt(a -> a[0]));
        return res[k - 1][0];
    }
}