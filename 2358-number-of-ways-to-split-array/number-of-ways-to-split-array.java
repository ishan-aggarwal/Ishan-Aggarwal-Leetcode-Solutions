class Solution {
    public int waysToSplitArray(int[] nums) {

        long[] forwardSum = new long[nums.length];
        long[] backwardSum = new long[nums.length];

        forwardSum[0] = nums[0];
        backwardSum[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            forwardSum[i] = nums[i] + forwardSum[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            backwardSum[i] = nums[i] + backwardSum[i + 1];
        }

        // 10, 14, 6, 13
        // 13, 3, -1 , 7      
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (forwardSum[i] >= backwardSum[i+1]) {
                count++;
            }
        }

        return count;
    }
}