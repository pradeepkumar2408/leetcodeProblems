class Solution {
    void dfs(boolean[][] vis, char[][] grid, int i, int j, int m, int n){
        vis[i][j] = true;
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};

        for(int l = 0; l < 4; l++){
            int ci = i + di[l], cj = j + dj[l];
            if(ci >= 0  && ci < m && cj >=0 && cj < n && grid[ci][cj] == '1' && !vis[ci][cj]){
                dfs(vis, grid, ci, cj, m, n);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length,n = grid[0].length, island = 0;
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(vis, grid, i, j, m, n);
                    island++;
                }
            }
        }
        return island;
    }
}