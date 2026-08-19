class Solution {
     void dfs(boolean[][] vis, int[][] board, int i, int j, int m, int n) {
        vis[i][j] = true;

        int[] di = { -1, 0, 1, 0 };
        int[] dj = { 0, 1, 0, -1 };

        for (int l = 0; l < 4; l++) {
            int ci = i + di[l], cj = j + dj[l];

            if (ci >= 0 && ci < m && cj >= 0 && cj < n && !vis[ci][cj] && board[ci][cj] == 1)
                dfs(vis, board, ci, cj, m, n);
        }
    }
    public int numEnclaves(int[][] board) {
         int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                    if(!vis[i][j] && board[i][j] == 1){
                        dfs(vis, board, i , j, m , n);
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && board[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
}