class Solution {
    boolean dfs(boolean[][] vis, char[][] board, int i, int j, String word, int index, int m, int n) {
        if (index == word.length())
            return true;
        int[] di = { 1, 0, -1, 0 };
        int[] dj = { 0, 1, 0, -1 };

        for (int l = 0; l < 4; l++) {
            int ci = i + di[l];
            int cj = j + dj[l];

            if (ci >= 0 && ci < m && cj >= 0 && cj < n && board[ci][cj] == word.charAt(index) && !vis[ci][cj]) {
                vis[ci][cj] = true;
                if (dfs(vis, board, ci, cj, word, index + 1, m, n))
                    return true;
                vis[ci][cj] = false;
            }
            
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    vis[i][j] = true;
                    if (dfs(vis, board, i, j, word, 1, m, n)) {
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }
}