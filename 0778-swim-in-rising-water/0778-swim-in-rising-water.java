class Pair {
    int dist;
    int row;
    int col;

    Pair(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.dist, y.dist));
        int n = grid.length;
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], (int) 1e9);
        }
        
        distance[0][0] = 0;
        pq.add(new Pair(grid[0][0],0,0));

        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};
        while(!pq.isEmpty()){
            int d = pq.peek().dist, i = pq.peek().row, j = pq.peek().col;
            pq.remove();

            for(int l = 0; l < 4; l++){
                int ci = i + di[l], cj = j + dj[l];
                if(ci >= 0 && ci < n && cj >= 0 && cj < n){
                 int newMax = Math.max(d, grid[ci][cj]);
                 if(distance[ci][cj] > newMax){
                    distance[ci][cj] = newMax;
                    pq.add(new Pair(newMax, ci, cj)); 
                 }   
                }
            }
        }
        return distance[n-1][n-1];
    }
}