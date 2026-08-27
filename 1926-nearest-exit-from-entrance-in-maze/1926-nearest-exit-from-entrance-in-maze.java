class Pair {
    int first;
    int second;
    int third;

    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(entrance[0], entrance[1], 0));
        vis[entrance[0]][entrance[1]] = true;

        int[] di = { -1, 0, 1, 0 };
        int[] dj = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int i = q.peek().first, j = q.peek().second, step = q.peek().third;
            q.remove();
            if ((i == m - 1 || j == n - 1 || i == 0 || j == 0) && (i != entrance[0] || j != entrance[1])) {
                return step;
            }
            for (int l = 0; l < 4; l++) {
                int ci = i + di[l], cj = j + dj[l];
                if (ci >= 0 && ci < m && cj >= 0 && cj < n && !vis[ci][cj] && maze[ci][cj] == '.') {
                    vis[ci][cj] = true;
                    q.add(new Pair(ci, cj, step + 1));
                }
            }
        }
        return -1;
    }
}