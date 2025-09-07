class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int x = n/2;
        int cnt = 0;
        for (int i = 0; i < n / 2; i++) {
            res[cnt++] = -1 * x;
            x--;
        }
        if (n % 2 != 0) {
            res[cnt++]= 0;
        }
        x = n / 2; 
        for (int i = 0; i < n / 2; i++) {
            res[cnt++] = x;
            x--;
        }
        return res;
    }
}