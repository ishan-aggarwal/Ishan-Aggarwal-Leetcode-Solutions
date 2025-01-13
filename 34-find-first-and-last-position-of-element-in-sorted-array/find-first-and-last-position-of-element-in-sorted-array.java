class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftMostIndex = findLeftMostIndex(nums, target);
        if (leftMostIndex == -1) {
            return new int[] {-1, -1};
        }
        int rightMostIndex = findRightMostIndex(nums, target);
        return new int[] {leftMostIndex, rightMostIndex};
    }

    private static int findLeftMostIndex(int[] A, int B) {
        int n = A.length;
        int l = 0, r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r -l) / 2;
            if (A[mid] == B) {
                ans = mid;
                r = mid - 1;
            } else if (A[mid] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


    private static int findRightMostIndex(int[] A, int B) {
        int n = A.length;
        int l = 0, r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r -l) / 2;
            if (A[mid] == B) {
                ans = mid;
                l = mid + 1;
            } else if (A[mid] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }    

    // private int binarySearch(int[] nums, int target, boolean findLeft) {
    //     int low = 0;
    //     int high = nums.length - 1;
    //     int index = -1;

    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         if (nums[mid] == target) {
    //             index = mid;
    //             if (findLeft) {
    //                 high = mid - 1;
    //             } else {
    //                 low = mid + 1;
    //             }
    //         } else if (nums[mid] < target) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }

    //     return index;
    // }
}
