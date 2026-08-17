class Solution {
    boolean dfs(boolean[][] vis, char[][] grid, int i, int j, int m, int n,int pi, int pj){
        vis[i][j] = true;
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};

        for(int l = 0; l < 4; l++){
            int ci = di[l] + i;
            int cj = dj[l] + j;
            if(ci >= 0 && ci < m && cj >= 0 && cj < n && grid[i][j] == grid[ci][cj]){
                if(ci == pi && cj == pj)
                    continue;
                else if(vis[ci][cj]){
                    return true;
                }
                if(dfs(vis,grid,ci,cj,m,n,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j]){
                    if(dfs(vis, grid, i, j, m, n, -1, -1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}