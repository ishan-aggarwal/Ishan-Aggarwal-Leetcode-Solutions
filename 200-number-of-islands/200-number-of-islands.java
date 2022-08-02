class Solution {
    
    
    
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
    
        int count = 0;
        for (int iPtr = 0; iPtr < rows; iPtr++) {
            
            for (int jPtr = 0; jPtr < cols; jPtr++) {
                
                if (grid[iPtr][jPtr] == '1') {
                    dfsHelper(grid, iPtr, jPtr);
                    count++;
                }
            }
            
        }
        
        return count;
    }
    
    
    private void dfsHelper(char[][] grid, int iPtr, int jPtr) {
        
        if (iPtr < 0 || jPtr < 0 || iPtr >= grid.length || jPtr >= grid[0].length) {
            return;
        }
        
        if (grid[iPtr][jPtr] == '0' || grid[iPtr][jPtr] == '2') {
            return;
        }
        
        grid[iPtr][jPtr] = '2';
        
        dfsHelper(grid, iPtr - 1, jPtr);
        dfsHelper(grid, iPtr + 1, jPtr);
        dfsHelper(grid, iPtr, jPtr - 1);
        dfsHelper(grid, iPtr, jPtr + 1);
        
    }
}