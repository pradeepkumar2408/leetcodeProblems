class Solution {
    void dfs(boolean[][] vis, int[][] ans, int i, int j, int ini, int color,int m, int n, int[][] image){
        vis[i][j] = true;
        ans[i][j] = color;
        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};

        for(int l = 0; l < 4; l++){
            int ci = i + di[l], cj = j + dj[l];

            if(ci >= 0 && ci < m && cj >= 0 && cj < n && image[ci][cj] == ini && !vis[ci][cj]){
                dfs(vis, ans, ci, cj, ini, color, m, n, image);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] ans = image;

        dfs(vis, ans, sr, sc, image[sr][sc], color, m , n, image);
        return ans;
    }
}