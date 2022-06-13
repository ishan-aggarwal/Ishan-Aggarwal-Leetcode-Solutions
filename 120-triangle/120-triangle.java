class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int[] row: memo)
        Arrays.fill(row, Integer.MAX_VALUE);

        return solve(0,0,triangle,memo);

    }

    int solve(int i,int j,List<List<Integer>> triangle,int[][] memo)
    {
        if(i==triangle.size())
        {
            return 0;
        }
        
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }

        int remain=Math.min(triangle.get(i).get(j)+solve(i+1,j,triangle,memo),
        triangle.get(i).get(j)+solve(i+1,j+1,triangle,memo));

        // int remain=Math.min(sum1,sum2);
        memo[i][j] = remain;
        return memo[i][j];
    }

}