class Node {
    int first;
    int second;
    int third;

    Node(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] ans = new int[m][n];

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int[] di = { -1, 0, 1, 0 };
        int[] dj = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int row = q.peek().first, col = q.peek().second, step = q.peek().third;
            q.remove();
            ans[row][col] = step;

            for (int l = 0; l < 4; l++) {
                int crow = row + di[l], ccol = col + dj[l];
                if (crow >= 0 && crow < m && ccol >= 0 && ccol < n && !vis[crow][ccol] && isWater[crow][ccol] == 0) {
                    q.add(new Node(crow, ccol, step + 1));
                    vis[crow][ccol] = true;
                }
            }
        }
        return ans;
    }
}