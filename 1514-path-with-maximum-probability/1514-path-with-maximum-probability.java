class Pair{
    double dist;
    int node;

    Pair(double dist, int node){
        this.dist = dist;
        this.node = node;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Double.compare(y.dist, x.dist));

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            double wt = succProb[i];

            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }
        double[] distance = new double[n];
        Arrays.fill(distance, Double.MIN_VALUE);

        distance[start] = 1.0;
        pq.add(new Pair(1.0, start));

        while(!pq.isEmpty()){
            double d = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();

            for(Pair p : adj.get(node)){
                double adjWeight = p.dist;
                int adjNode = p.node;

                if(distance[adjNode] < d * adjWeight){
                    distance[adjNode] = d * adjWeight;
                    pq.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        return distance[end] == Double.MIN_VALUE ? 0 : distance[end];
    }
}