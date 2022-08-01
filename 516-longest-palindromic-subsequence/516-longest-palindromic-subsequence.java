class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String newS = sb.toString();
        
        int len = s.length();
        int[][] dp = new int[len][len];
        
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        
        int ans = findLPS(s, newS, len - 1, len - 1, dp);
        return ans;
    }
    
    private int findLPS(String s, String s1, int i, int j, int[][] dp) {
        
        if (i == -1 || j == -1) {
            return 0;
        }
        
        if (dp[i][j]  == -1) {
            if (s.charAt(i) == s1.charAt(j)) {
                dp[i][j] = 1 +  findLPS(s, s1, i - 1, j - 1, dp);
            } else {
                dp[i][j] = Math.max(findLPS(s, s1, i, j - 1, dp), findLPS(s, s1, i - 1, j, dp));
            }
        }   
        return dp[i][j];
    }
}