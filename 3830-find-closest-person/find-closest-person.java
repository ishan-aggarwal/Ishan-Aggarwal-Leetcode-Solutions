class Solution {
    public int findClosest(int x, int y, int z) {
        if (Math.abs(x - z) < Math.abs(y - z)) {
            return 1;
        } else if (Math.abs(x - z) > Math.abs(y - z)) {
            return 2;
        } else {
            return 0;
        }
    }
}