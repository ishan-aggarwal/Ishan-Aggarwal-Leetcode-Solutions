class Solution {

    static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // If the start or end cell is blocked, no path exists
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        grid[0][0] = 1; // Mark the start cell as visited (use 1 as distance)

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int currentDistance = grid[currentX][currentY];

            // If we reach the destination, return the distance
            if (currentX == n - 1 && currentY == n - 1) {
                return currentDistance;
            }

            // Explore all 8 possible directions
            for (int[] direction : directions) {
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];

                // Check if the new cell is within bounds and unvisited
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                    queue.add(new Point(newX, newY));
                    grid[newX][newY] = currentDistance + 1; // Mark visited and store distance
                }
            }
        }

        // If no path exists
        return -1;

    }
}