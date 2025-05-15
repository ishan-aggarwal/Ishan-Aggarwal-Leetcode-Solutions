class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1); // reverse entire n elements 
        reverse(nums, 0, k - 1); // reverse first k elements
        reverse(nums, k, n - 1); // reverse remaining n - k elements
    }

    public void reverse(int[] nums, int l, int r) {
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

}