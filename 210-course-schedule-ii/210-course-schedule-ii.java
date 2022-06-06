class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] answer = new int[numCourses];
        int c = 0;
        
        int[] indegree = new int[numCourses];
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge : prerequisites) {
            (adjList.get(edge[1])).add(edge[0]);
            indegree[edge[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }   
        }
        
        while (queue.size() > 0) {
            
            int u = queue.poll();
            answer[c++] = u;
            
            List<Integer> nodes = adjList.get(u);
            
            for (Integer v : nodes) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        
        if (c == numCourses) {
            return answer;
        }
        
        return new int[] {};
    }
}