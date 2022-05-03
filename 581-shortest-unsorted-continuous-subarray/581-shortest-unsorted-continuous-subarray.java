class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        // int start = snums.length, end = 0;
        int start= -1, end = -1;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                // start = Math.min(start, i);
                // end = Math.max(end, i);
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }
        // return (end - start >= 0 ? end - start + 1 : 0);   
        if (start == -1) return 0;
        return end - start + 1;
    }
}