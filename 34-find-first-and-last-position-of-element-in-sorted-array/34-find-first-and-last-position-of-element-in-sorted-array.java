class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int firstOccurrence = this.findBound(nums, target, true);
        
        if (firstOccurrence == -1) {
            return new int[]{-1, -1};
        }
        
        int lastOccurrence = this.findBound(nums, target, false);
        
        return new int[]{firstOccurrence, lastOccurrence};
    }
    
    private int findBound(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int begin = 0, end = N - 1;
        
        while (begin <= end) {
            
            int mid = (begin + end) / 2;
            
            if (nums[mid] == target) {
                
                if (isFirst) {
                    
                    // This means we found our lower bound.
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid;
                    }
                    
                    // Search on the left side for the bound.
                    end = mid - 1;
                    
                } else {
                    
                    // This means we found our upper bound.
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    
                    // Search on the right side for the bound.
                    begin = mid + 1;
                }
                
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        
        return -1;
    }
    
    
        // Another way with two separate functions 
    
//         public int[] searchRange(int[] nums, int target) {
        
//         // basically we are trying to find first possible position
//         // in case there is a match, then also we are not returning
//         // we are decreasing right pointer by mid - 1
//         // and setting current mid to possible first position
//         int fp = findFirstPos(nums, target);
        
//         // if fp is not found, is -1
//         // then we can safely assume element is not found and return -1, -1
//         if (fp == -1) { return new int[] {-1, -1}; }
        
//         // next we are finding lp
//         // for this if we found a match
//         // then we are not returning and we are increasing left by mid + 1
//         // and setting current left to possible lp
//         int lp = findLastPos(nums, target);
//         return new int[] {fp, lp}; 
//     }
    
//     public int findFirstPos(int[] nums, int x) {
//         int l = 0;
//         int r = nums.length - 1;
//         int fp = -1;
//         while (l <= r) {
//             int mid = l + (r - l) /2;
            
//             if (nums[mid] == x) {
//                 fp = mid;
//                 r = mid - 1;
//             } else if (nums[mid] > x) {
//                 r = mid - 1;
//             } else {
//                 l = mid + 1;
//             }
//         }
//         return fp;
//     }
    
//     public int findLastPos(int[] nums, int x) {
//         int l = 0;
//         int r = nums.length - 1;
//         int lp = -1;
//         while (l <= r) {
//             int mid = l + (r - l) /2;
            
//             if (nums[mid] == x) {
//                 lp = mid;
//                 l = mid + 1;
//             } else if (nums[mid] > x) {
//                 r = mid - 1;
//             } else {
//                 l = mid + 1;
//             }
//         }
//         return lp;
//     }
}