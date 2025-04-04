class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int r = n + m - 1;

        int l1 = m - 1;
        int l2 = n - 1;

        while (l1 >= 0 && l2 >= 0) {
            if(nums1[l1] > nums2[l2]) {
                nums1[r] = nums1[l1];
                l1--;
            } else {
                nums1[r] = nums2[l2];
                l2--;
            }
            r--;
        }

        while (l1 >= 0) {
            nums1[r] = nums1[l1];
            r--;
            l1--;
        }

        while (l2 >= 0) {
            nums1[r] = nums2[l2];
            r--;
            l2--;
        }
    }
}