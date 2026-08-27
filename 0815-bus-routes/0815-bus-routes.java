class Pair {
    int[] first;
    int second;

    Pair(int[] first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
        boolean[] vis = new boolean[routes.length];
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                mp.computeIfAbsent(routes[i][j], k -> new ArrayList<>()).add(i);
                if (routes[i][j] == source) {
                    vis[i] = true;
                    q.add(new Pair(routes[i], 1));
                }
            }
        }

        while (!q.isEmpty()) {
            int[] stops = q.peek().first;
            int ans = q.peek().second;
            q.remove();

            for (int i = 0; i < stops.length; i++) {
                if (stops[i] == target)
                    return ans;
                ArrayList<Integer> temp = mp.get(stops[i]);
                for (int j = 0; j < temp.size(); j++) {
                    int bus = temp.get(j);
                    if (!vis[bus]) {
                        vis[bus] = true;
                        q.add(new Pair(routes[bus], ans + 1));
                    }
                }
            }
        }
        return -1;
    }
}