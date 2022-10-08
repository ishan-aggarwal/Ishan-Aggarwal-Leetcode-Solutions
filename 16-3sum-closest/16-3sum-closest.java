class Solution {
    public int threeSumClosest(int[] nums, int target) {
   
        Arrays.sort(nums);
        int length = nums.length;
        int answer = nums[0] + nums[1] + nums[2];

        int lPtr, rPtr;

        for (int i = 0; i < length - 2; ++i) {
            lPtr = i+1;
            rPtr = length - 1;
            while (lPtr < rPtr) {
                int sum = nums[i] + nums[lPtr] + nums[rPtr];
                if (Math.abs(sum - target) < Math.abs(answer - target)) {
                    answer = sum;
                }
                if (target > sum) {
                    lPtr++;
                } else {
                    rPtr--;
                }
            }
        }

        return answer;
    }
}