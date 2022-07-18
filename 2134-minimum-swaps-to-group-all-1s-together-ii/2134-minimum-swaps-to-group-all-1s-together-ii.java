class Solution {
    public int minSwaps(int[] nums) {
        
        int minZeroMoves = minMoves(nums, 0);
        int minOneMoves = minMoves(nums, 1);
        return Math.min(minZeroMoves, minOneMoves);
    }
    
    public int minMoves(int[] nums, int val) {
        
        int max = 0;
        for (int e : nums) {
            if (e == val) {
                max++;
            }
        }
        
        int cntVal = 0;
        int left = 0;
        int right = 0;
        int maxInWindow = 0;
        
        while (right < nums.length) {
            if (nums[right] == val) {
                cntVal++;
            }
            right++;
            
            if (right - left > max) {
                if (nums[left] == val) {
                    cntVal--;
                }
                left++;
            }
            maxInWindow = Math.max(cntVal, maxInWindow);
        }
        return max - maxInWindow;
    }
    
}