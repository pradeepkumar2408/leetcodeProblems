class Pair {
    int x;
    int y;
    int step;
    int count;

    Pair(int x, int y, int step, int count) {
        this.x = x;
        this.y = y;
        this.step = step;
        this.count = count;
    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] vis = new boolean[m][n][k + 1];
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> Integer.compare(x.step, y.step));
        q.add(new Pair(0, 0, 0, 0));
        vis[0][0][0] = true;
        int[] di = { -1, 0, 1, 0 };
        int[] dj = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int i = q.peek().x, j = q.peek().y, steps = q.peek().step, c = q.peek().count;
            q.remove();

            if (i == m - 1 && j == n - 1)
                return steps;
            if (c > k)
                continue;
            for (int l = 0; l < 4; l++) {
                int ci = i + di[l], cj = j + dj[l];

                if (ci >= 0 && ci < m && cj >= 0 && cj < n) {
                    int newCount = c + grid[ci][cj];
                    if (newCount <= k && !vis[ci][cj][newCount]) {
                        vis[ci][cj][newCount] = true;
                        q.add(new Pair(ci, cj, steps + 1, newCount));
                    }
                }
            }
        }
        return -1;
    }
}