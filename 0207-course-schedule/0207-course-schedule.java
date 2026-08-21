class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0], v = prerequisites[i][1];
            adj.get(u).add(v);
        }

        ArrayList<Integer> res = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            for(int it : adj.get(i))
                indegree[it]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it); 
            }
        }
        return res.size() == numCourses ? true : false;
    }
}