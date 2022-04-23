class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        // basically we are trying to find first possible position
        // in case there is a match, then also we are not returning
        // we are decreasing right pointer by mid - 1
        // and setting current mid to possible first position
        int fp = findFirstPos(nums, target);
        
        // if fp is not found, is -1
        // then we can safely assume element is not found and return -1, -1
        if (fp == -1) { return new int[] {-1, -1}; }
        
        // next we are finding lp
        // for this if we found a match
        // then we are not returning and we are increasing left by mid + 1
        // and setting current left to possible lp
        int lp = findLastPos(nums, target);
        return new int[] {fp, lp}; 
    }
    
    public int findFirstPos(int[] nums, int x) {
        int l = 0;
        int r = nums.length - 1;
        int fp = -1;
        while (l <= r) {
            int mid = l + (r - l) /2;
            
            if (nums[mid] == x) {
                fp = mid;
                r = mid - 1;
            } else if (nums[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return fp;
    }
    
    public int findLastPos(int[] nums, int x) {
        int l = 0;
        int r = nums.length - 1;
        int lp = -1;
        while (l <= r) {
            int mid = l + (r - l) /2;
            
            if (nums[mid] == x) {
                lp = mid;
                l = mid + 1;
            } else if (nums[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return lp;
    }
}