class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] vis = new boolean[arr.length];
        vis[start] = true;

        while(!q.isEmpty()){
            int i = q.poll();
            if(arr[i] == 0)
                return true;
            int ci = i + arr[i], cj = i - arr[i];
            if(ci < arr.length && !vis[ci]){
                q.add(ci);
                vis[ci] = true;
            }
            if(cj >= 0 && !vis[cj]){
                q.add(cj);
                vis[cj] = true;
            }
        }
        return false;
    }
}