class Solution {
    int ans = 0;
    void dfs(boolean[][] vis, int[][] grid, int m, int n, int i, int j, int cell){
        if(grid[i][j] == 2){
            if(cell + 1 == 0)
                ans++;
            return;
        }
        int[] di ={-1,0,1,0};
        int[] dj = {0,1,0,-1};

        for(int l = 0; l < 4; l++){
            int ci = i + di[l] , cj = j + dj[l];
            if(ci >= 0 && ci < m && cj >= 0 && cj < n && !vis[ci][cj] && grid[ci][cj] != -1){
                vis[ci][cj] = true;
                dfs(vis, grid, m, n, ci, cj, cell - 1);
                vis[ci][cj] = false;
            }
        }
    }
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length, cell = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0)
                    cell++;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    vis[i][j] = true;
                    dfs(vis, grid, m, n, i , j, cell);
                }
            }
        }
        return ans;
    }
}