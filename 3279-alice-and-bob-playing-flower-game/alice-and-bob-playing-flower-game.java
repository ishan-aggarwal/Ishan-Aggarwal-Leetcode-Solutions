class Solution {
    public long flowerGame(int n, int m) {
        
        long count = 0; 
        for (int i = 1; i <= n; i++) {

            if ( i % 2 == 0) {
                count += ( m % 2 != 0) ? (m + 1) / 2 : (m / 2); 
            } else {
                count += (m / 2);
            }
        }
        return count;
    }
}