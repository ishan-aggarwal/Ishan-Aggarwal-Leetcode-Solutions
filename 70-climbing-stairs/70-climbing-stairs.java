class Solution {
    public int climbStairs(int n) {
        
        if (n <= 1) return 1;
        if (n == 2) return 2;

        int first = 1;
        int second = 1;
        int current = first + second;
        
        for (int i = 2; i <= n; i++) {
            current = first + second;
            first = second;
            second = current;
        }
        
        return current;
    }
}