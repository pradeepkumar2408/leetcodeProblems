class Solution {
    void dfs(int[][] heights, boolean[][] vis, int i, int j, int m, int n){
        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};

        for(int l = 0; l < 4; l++){
            int ci = i + di[l], cj = j + dj[l];
            if(ci >= 0 && ci < m && cj >= 0 && cj < n && !vis[ci][cj] && heights[i][j] <= heights[ci][cj]){
                vis[ci][cj] = true;
                dfs(heights, vis, ci, cj, m, n);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    pacific[i][j] = true;
                    dfs(heights, pacific, i, j, m, n);
                }
                if(i == m - 1 || j == n - 1){
                    atlantic[i][j] = true;
                    dfs(heights, atlantic, i , j, m, n);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                List<Integer> ans = new ArrayList<>();
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(i);
                    ans.add(j);
                    res.add(ans);
                }
            }
            
        }
        return res;
    }
}