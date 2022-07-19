class Solution {
    
    // Time complexity: O(numRows^2)
    // Space complexity : O(1), the space used for storing the results/answer is O(numRows^2) which is not considered in the SC.
    
    public List<List<Integer>> generate(int numRows) {
        
        // hold the master list of list
        List<List<Integer>> answer = new ArrayList<>(numRows);
        
        // first row to be used in answer with value 1
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        answer.add(firstRow);
        
        
        // for the remaining number of rows in answer
        for (int i = 1; i < numRows; i++) {
            
            // extract the previous row from answer
            List<Integer> prevRow = answer.get(i-1);
            
            // is the current row and add 1 to it
            List<Integer> row = new ArrayList<>();
            row.add(1);
            
            // for the middle elements of the current row
            // they are sum of the previous row 2 elements
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            // also the last element of each row is 1
            row.add(1);
            
            // add the current row to the answer
            answer.add(row);
        }
        return answer;    
    }
}