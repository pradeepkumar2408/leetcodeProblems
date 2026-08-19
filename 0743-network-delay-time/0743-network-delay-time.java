class Pair{
    int dist;
    int node;

    Pair(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.dist, y.dist));
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++){
            int u = times[i][0], v = times[i][1], wt = times[i][2];

            adj.get(u).add(new Pair(wt, v));
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int)(1e9));

        distance[k] = 0;
        pq.add(new Pair(0,k));

        while(!pq.isEmpty()){
            int d = pq.peek().dist, node = pq.peek().node;
            pq.remove();

            for(Pair p : adj.get(node)){
                int adjWeight = p.dist, adjNode = p.node;

                if(distance[adjNode] > d + adjWeight){
                    distance[adjNode] = d + adjWeight;
                    pq.add(new Pair(distance[adjNode],adjNode));
                }
            }
        }

        int max = 0;
        for(int i = 1 ; i <= n ; i++){
            if(distance[i] == (int)(1e9) )
                return -1;
            max = Math.max(max, distance[i]);
        }
        return max;
    }
}