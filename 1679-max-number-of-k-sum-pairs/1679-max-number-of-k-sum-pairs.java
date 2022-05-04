class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        
        int i = 0, j = nums.length - 1;
        
        int countOperations = 0;
        
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                countOperations++;
                i++;
                j--;
            } else if (nums[i] + nums[j] > k) {
                j--; 
            } else {
                i++;
            }
        }
        
        return countOperations;
    }
}