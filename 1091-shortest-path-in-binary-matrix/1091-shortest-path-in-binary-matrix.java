class Pair{
    int first;
    int second;
    int third;

    Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.third,y.third));
        boolean[][] vis =new  boolean[m][n];
        if(grid[0][0] == 0){
            pq.add(new Pair(0,0,1));
            vis[0][0] = true;
        }
        else
            return -1;
        while(!pq.isEmpty()){
            int i = pq.peek().first, j = pq.peek().second, step = pq.peek().third;
            pq.remove();
            
            if(i == m-1 && j == n-1)
                return step;
            for(int k = -1; k <= 1; k++){
                for(int l = -1; l <= 1; l++){
                    if(k == 0 && l == 0)
                        continue;
                    else{
                        int ci = i + k , cj = j + l;
                        if(ci >= 0 && ci < m && cj >= 0 && cj < n && !vis[ci][cj] && grid[ci][cj] == 0){
                            vis[ci][cj] = true;
                            pq.add(new Pair(ci, cj, step + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}