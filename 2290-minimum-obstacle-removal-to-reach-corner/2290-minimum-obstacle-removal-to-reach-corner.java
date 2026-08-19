class Pair{
    int wall; 
    int row;
    int col;

    Pair(int wall, int row, int col){
        this.wall = wall;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.wall, y.wall));
        int m = grid.length, n = grid[0].length;

        int[][] distance = new int[m][n];

        for(int i = 0; i < m ; i++){
            Arrays.fill(distance[i], (int) 1e9);
        }
        distance[0][0] = grid[0][0];
        pq.add(new Pair(grid[0][0],0,0));

        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};
        while(!pq.isEmpty()){
            int d = pq.peek().wall, i = pq.peek().row, j = pq.peek().col;
            pq.remove();
            for(int l = 0; l < 4; l++){
                int ci = i + di[l], cj = j + dj[l];
                if(ci >= 0 && ci < m && cj >= 0 && cj < n){
                    int newMax = Math.max(d, d + grid[ci][cj]);
                    if(distance[ci][cj] > newMax){
                        distance[ci][cj] = newMax;
                        pq.add(new Pair(newMax, ci, cj));
                    }
                }
            }
        }
        return distance[m-1][n-1];
    }
}