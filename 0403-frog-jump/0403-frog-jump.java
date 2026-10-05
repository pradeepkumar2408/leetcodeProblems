class Solution {
    boolean dpCalculate(int i, int k, int[] stones, Map<Integer, Integer> mp, int n, int[][] dp){
        if(i == n - 1)
            return true;
        if(dp[i][k] != -1)
            return dp[i][k] == 1 ? true : false;
        boolean ans = false;
        if(i == 0){
            if(mp.containsKey(stones[i] + 1)){
                ans = ans || dpCalculate(mp.get(stones[i] + 1), k + 1, stones, mp, n, dp);
            }
        }else{
            if(k - 1 > 0 && mp.containsKey(stones[i] + (k - 1)))
                ans = ans || dpCalculate(mp.get(stones[i] + (k - 1)), k - 1, stones, mp, n, dp);
            if(mp.containsKey(stones[i] + (k)))
                ans = ans || dpCalculate(mp.get(stones[i] + (k)), k, stones, mp, n, dp);
            if(mp.containsKey(stones[i] + (k + 1)))
                ans = ans || dpCalculate(mp.get(stones[i] + (k + 1)), k + 1, stones, mp, n, dp);
        }
        dp[i][k] = ans ? 1 : 0;
        return ans;
    }
    public boolean canCross(int[] stones) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = stones.length;
        for(int i = 0; i < stones.length; i++){
            mp.put(stones[i], i);
        }
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n; i++)
            Arrays.fill(dp[i], -1);
        return dpCalculate(0, 0, stones, mp, n, dp);
    }
}