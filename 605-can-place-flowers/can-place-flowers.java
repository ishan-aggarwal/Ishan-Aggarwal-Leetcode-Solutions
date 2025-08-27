class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        
        for (int i = 0; i < len && n > 0; i++) {
            if (flowerbed[i] == 0) {
                
                // fetch left and right
                int left = safeGet(flowerbed, i - 1);
                int right = safeGet(flowerbed, i + 1);

                if (left == 0 && right == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n == 0;
    }

    public int safeGet(int[] f, int idx) {
        if (idx >= 0 && idx < f.length) {
            return f[idx];
        }
        return 0;
    }
}
