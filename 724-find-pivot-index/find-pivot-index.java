class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] ps = new int[n];
        int[] ss = new int[n];

        ps[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + nums[i];
        }
        //1, 8, 11, 17, 22, 28
        //2, 3, 2

        ss[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ss[i] = ss[i + 1] + nums[i];
        }
        //6, 11, 17, 20, 27, 28
        //2 0 -1


        for (int i = 0; i < n - 1; i++) {
            if (i == 0) {
                if (ps[i] == ss[i]) {
                    return i;
                }
            } else if (ps[i - 1] == ss[i + 1]) {
                return i;
            }
        }
        return ps[n - 1] == ss[n -1] ? n - 1 : -1;
    }
}