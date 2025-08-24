class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i <= j) {
            if (nums[j] == val) {
                j--;
            } else if (nums[i] == val) {
                swap(nums, i, j);
                i++;
                j--;
            } else {
                i++;
            }
        }
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}