class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        // Approach 1.
        // Using sorting
        // TC - O(n log n) and SC - O(n)
        
        // int[] snums = nums.clone();
        // Arrays.sort(snums);
        // // int start = snums.length, end = 0;
        // int start= -1, end = -1;
        // for (int i = 0; i < snums.length; i++) {
        //     if (snums[i] != nums[i]) {
        //         // start = Math.min(start, i);
        //         // end = Math.max(end, i);
        //         if (start == -1) {
        //             start = i;
        //         } else {
        //             end = i;
        //         }
        //     }
        // }
        // // return (end - start >= 0 ? end - start + 1 : 0);   
        // if (start == -1) return 0;
        // return end - start + 1;
        
        // Approach 2.
        // 2, 6, 4, 8, 10, 9, 15
        // Using two stacks to find the min index and max index of the unsorted array
        
        // TC - O(N) and SC - O(N)
        Stack < Integer > stack = new Stack < Integer > ();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }

        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;

    }
}