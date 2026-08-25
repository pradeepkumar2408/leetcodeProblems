class Pair {
    int stop;
    int dist;
    int node;

    Pair(int stop, int dist, int node) {
        this.stop = stop;
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.stop, y.stop));
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0], v = flights[i][1], wt = flights[i][2];
            adj.get(u).add(new Pair(0, wt, v));
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int) (1e9));

        distance[src] = 0;
        pq.add(new Pair(0,0, src));

        while (!pq.isEmpty()) {
            int d = pq.peek().dist, node = pq.peek().node, stops = pq.peek().stop;
            pq.remove();

            if (stops > k) continue;

            for (Pair p : adj.get(node)) {
                int adjWeight = p.dist, adjNode = p.node;
                int newDist = d + adjWeight; 

                
                    if (newDist < distance[adjNode] && stops <= k) {
                        distance[adjNode] = newDist;
                         pq.add(new Pair(stops + 1,newDist, adjNode));
                    }
            }
        }

        return distance[dst] == (int) (1e9) ? -1 : distance[dst];
    }
}