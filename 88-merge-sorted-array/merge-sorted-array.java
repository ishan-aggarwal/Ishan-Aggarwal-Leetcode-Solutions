class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] c = new int[m + n];

        int idx = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                c[idx++] = nums1[i++];
            } else {
                c[idx++] = nums2[j++];
            }
        }

        while (i < m) {
            c[idx++] = nums1[i++];
        }

        while (j < n) {
            c[idx++] = nums2[j++];
        }

        for (i = 0; i < n + m; i++) {
            nums1[i] = c[i];
        }
    }
}