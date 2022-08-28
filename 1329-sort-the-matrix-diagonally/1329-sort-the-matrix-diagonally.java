class Solution {
    public int[][] diagonalSort(int[][] mat) {
        // Store the matrix dimensions
        int m = mat.length;
        int n = mat[0].length;
        
        // Data structure to store the diagonals.
        Map<Integer, Queue<Integer>> diagonals = new HashMap<>();
        
        // Insert values into the HashMap.
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) { 
                diagonals.putIfAbsent(row - col, new PriorityQueue<>());
                diagonals.get(row - col).add(mat[row][col]);
            }   
        }

        // Take values back out of the HashMap.
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                mat[row][col] = diagonals.get(row - col).remove();
            }
        }
        
        return mat;
    }
}