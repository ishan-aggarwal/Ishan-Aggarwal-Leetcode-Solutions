class Solution {
    public int[][] sortMatrix(int[][] grid) {
        // 3,0
        // 2,0
        int rows = grid.length;
        int cols = grid[0].length;

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                map.putIfAbsent(key, key < 0 ? new PriorityQueue<>() : 
                                        new PriorityQueue<>(Collections.reverseOrder()));
                map.get(key).offer(grid[i][j]);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                grid[i][j] = map.get(key).poll();
            }
        }

        return grid;
    }
}