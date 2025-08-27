class NumArray {

    int[] ps;

    public NumArray(int[] nums) {
        int n = nums.length;
        ps = new int[n];
        ps[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return ps[right];
        }
        return ps[right] - ps[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */