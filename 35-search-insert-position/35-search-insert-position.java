class Solution {
    
    // make use of binary search to find the correct insert position
    // calculate mid and check for the insert pos
    // if equal return mid only
    
    // otherwise when the while loop breaks, then l will point to the insertion position for element 
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        if (target < nums[l]) {
            return l;
        } else if (target > nums[r]) {
            return r + 1;
        }
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        // l will point to the location where the element can be inserted in case 
        // it is not present in the array
        return l;
    }
}