class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        
        for(int[] curr : prerequisites) {
            (adjList.get(curr[0])).add(curr[1]);
            indegree[curr[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        
        int count = 0;
        while (queue.size() > 0) {
            int vertex = queue.poll();
            count++;
            
            List<Integer> nodes = adjList.get(vertex);
            for (int v : nodes) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        
        
        if (count == numCourses) {
            return true;
        }
        
        return false;
        
    }
}