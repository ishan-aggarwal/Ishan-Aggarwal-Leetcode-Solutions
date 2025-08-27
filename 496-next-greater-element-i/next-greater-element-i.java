class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ngm = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int len = nums2.length - 1;
        for (int i = len; i >= 0; i--) {
            int ele = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= ele) {
                stack.pop();
            }
            ngm.put(ele, stack.isEmpty() ? -1 : stack.peek());
            stack.push(ele);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = ngm.getOrDefault(nums1[i], 0);
        }
        return res;
    }
}