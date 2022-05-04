class Solution {
    
    // TC - O(N) and SC - O(1)
    public int climbStairs(int n) {
        
        // base cases
        if (n <= 1) return 1;
        if (n == 2) return 2;
        
        int a = 1, b = 1;
        int c = a + b;
        
        
        // Consider the simple scenario here
        // as we need to add the number of ways to reach to the destination from start or start from destination
        // if we are standing at Nth (3) stair...
        // and we take one step down to come to 2nd stair...then we know from 2nd stair there are two ways to reach zeroth stair
        // similary if we are standing of Nth (3) stair...
        // and we take two steps down to come to the 1st stair... then we know from there there is only 1 way to reach the zeroth stair..
        // so we need to combine all possible ways by either jumping one stair at a time or two stairs at a time
        
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        
        return c;
    }
}