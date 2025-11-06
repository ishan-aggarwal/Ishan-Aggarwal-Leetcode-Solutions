class Vertex {

    public int vertexId;
    public boolean offline = false;
    public int powerGridId = -1;

    public Vertex() {}

    public Vertex(int id) {
        this.vertexId = id;
    }
}

class Graph {

    private Map<Integer, List<Integer>> adj;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        this.adj = new HashMap<>();
        this.vertices = new HashMap<>();
    }

    public void addVertex(int id, Vertex value) {
        this.vertices.put(id, value);
        this.adj.put(id, new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        this.adj.get(u).add(v);
        this.adj.get(v).add(u);
    }

    public Vertex getVertexValue(int id) {
        return this.vertices.get(id);
    }

    public List<Integer> getConnectedVertices(int id) {
        return this.adj.get(id);
    }
}

class Solution {

    private void traverse(
        Vertex u,
        int powerGridId,
        PriorityQueue<Integer> powerGrid,
        Graph graph
    ) {
        u.powerGridId = powerGridId;
        powerGrid.add(u.vertexId);
        for (int vid : graph.getConnectedVertices(u.vertexId)) {
            Vertex v = graph.getVertexValue(vid);
            if (v.powerGridId == -1) {
                traverse(v, powerGridId, powerGrid, graph);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Graph graph = new Graph();
        for (int i = 0; i < c; i++) {
            Vertex v = new Vertex(i + 1);
            graph.addVertex(i + 1, v);
        }

        for (int[] conn : connections) {
            graph.addEdge(conn[0], conn[1]);
        }

        List<PriorityQueue<Integer>> powerGrids = new ArrayList<>();
        for (int i = 1, powerGridId = 0; i <= c; i++) {
            Vertex v = graph.getVertexValue(i);
            if (v.powerGridId == -1) {
                PriorityQueue<Integer> powerGrid = new PriorityQueue<>();
                traverse(v, powerGridId, powerGrid, graph);
                powerGrids.add(powerGrid);
                powerGridId++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int op = q[0];
            int x = q[1];
            if (op == 1) {
                Vertex vertex = graph.getVertexValue(x);
                if (!vertex.offline) {
                    ans.add(x);
                } else {
                    PriorityQueue<Integer> powerGrid = powerGrids.get(
                        vertex.powerGridId
                    );
                    while (
                        !powerGrid.isEmpty() &&
                        graph.getVertexValue(powerGrid.peek()).offline
                    ) {
                        powerGrid.poll();
                    }
                    ans.add(!powerGrid.isEmpty() ? powerGrid.peek() : -1);
                }
            } else if (op == 2) {
                graph.getVertexValue(x).offline = true;
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}