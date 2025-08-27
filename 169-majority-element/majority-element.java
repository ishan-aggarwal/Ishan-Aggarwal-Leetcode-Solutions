class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int ele = nums[i];


            if (count == 0) {
                ans = ele;
            }

            if (ele == ans) {
                count++;
            } else {
                count--;
            }


        }
        return ans;
    }
}