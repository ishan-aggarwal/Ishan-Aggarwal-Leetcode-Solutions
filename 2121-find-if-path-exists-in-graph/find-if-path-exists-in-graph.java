class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());    
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int s = edge[0];
            int d = edge[1];

            adjList.get(s).add(d);
            adjList.get(d).add(s);
        }

        boolean[] visited = new boolean[n];

        visited[source] = true;

        for (int children : adjList.get(source)) {
            if (!visited[children]) {
                callDFS(children, visited, adjList);
            }
        }

        return visited[destination];
    }

    private static void callDFS(int vertex, boolean[] visited, List<List<Integer>> adjList) {
        
        visited[vertex] = true;
        for (int children : adjList.get(vertex)) {
            if (!visited[children]) {
                callDFS(children, visited, adjList);
            }
        }
    }
}