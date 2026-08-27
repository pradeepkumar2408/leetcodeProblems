class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        boolean[] vis = new boolean[n];
        int[] col = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for (int start = 0; start < n; start++) {

            if (vis[start])
                continue;

            q.add(start);
            vis[start] = true;
            col[start] = 1;

            while (!q.isEmpty()) {

                int node = q.remove();

                for (int it : graph[node]) {

                    if (!vis[it]) {
                        vis[it] = true;
                        col[it] = 3 - col[node];
                        q.add(it);
                    }

                    else if (col[it] == col[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}