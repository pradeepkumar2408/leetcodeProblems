class Solution {
    int dpCalculate(int i , int j, List<List<Integer>> triangle, int[][] dp){
        if(i >= triangle.size() || j >= triangle.get(i).size())
            return (int)1e7;
        if(i == triangle.size() - 1 && j < triangle.get(i).size())
            return triangle.get(i).get(j);
        if(dp[i][j] != (int)-1e9)
            return dp[i][j];
        int ans = (int)1e7;
        ans = Math.min(ans, triangle.get(i).get(j) + dpCalculate(i + 1,j, triangle, dp));
        ans = Math.min(ans, triangle.get(i).get(j) + dpCalculate(i + 1, j + 1, triangle, dp));
        return dp[i][j] = ans;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], (int)-1e9);
        return dpCalculate(0,0,triangle, dp);
    }
}