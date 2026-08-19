class Pair {
    int effort;
    int row;
    int col;

    Pair(int effort, int row, int col) {
        this.effort = effort;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.effort, y.effort));

        int[][] distance = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], (int) 1e9);
        }

        distance[0][0] = 0;

        pq.add(new Pair(0, 0, 0));
        int[] di = { -1, 0, 1, 0 };
        int[] dj = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            int curr = pq.peek().effort, i = pq.peek().row, j = pq.peek().col;
            pq.remove();

            for (int l = 0; l < 4; l++) {
                int ci = i + di[l], cj = j + dj[l];

                if (ci >= 0 && ci < m && cj >= 0 && cj < n) {
                    int newDiff = Math.max(curr, Math.abs(heights[ci][cj] - heights[i][j]));
                    if (newDiff < distance[ci][cj]) {
                        distance[ci][cj] = newDiff;
                        pq.add(new Pair(newDiff, ci, cj));
                    }
                }
            }
        }
        return distance[m - 1][n - 1];
    }
}