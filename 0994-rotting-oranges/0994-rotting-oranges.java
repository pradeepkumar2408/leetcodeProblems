class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, fresh = 0;
        boolean[][] vis = new boolean[m][n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(i);
                    q.add(j);
                } else if (grid[i][j] == 1)
                    fresh++;
            }
        }
        int time = 0;
        int[] di = { 0, 1, 0, -1 };
        int[] dj = { 1, 0, -1, 0 };
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            while (size != 0) {
                int i = q.poll(), j = q.poll();

                for (int l = 0; l < 4; l++) {
                    int ci = i + di[l], cj = j + dj[l];
                    if (ci >= 0 && ci < m && cj >= 0 && cj < n && grid[ci][cj] == 1 && !vis[ci][cj]) {
                        q.add(ci);
                        q.add(cj);
                        fresh--;
                        vis[ci][cj] = true;
                    }
                }
                size -= 2;
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}