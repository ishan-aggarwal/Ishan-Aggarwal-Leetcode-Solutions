class Solution {
    
    
// Monotonic Stack
// We can use a stack to store the element of the array from the back to front, find nums[k] in the stack, and then continue to scan forward to find nums[i].

// The stack must store elements with a larger index and a smaller value than nums[j].

// The process is like this:

// Scanning from the back to the front, if the current element nums[i] is larger than the top of the stack, which means nums[i] may be the nums[j] we are looking for;

// Pop all the elements in the stack that are smaller than it. These elements are the the nums[k], and the last pop-up is the maximum qualified nums[k].

// If this num[k] is larger than the nums[i] scanned forward, we find the answer.


    
    public boolean find132pattern(int[] nums) {
        
        int len = nums.length;
        if (len < 3) {
            return false;
        }

        Deque<Integer> stk = new ArrayDeque<>();
        int k = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (k > -1 && nums[k] > nums[i]) {
                return true;
            }

            while (!stk.isEmpty() && nums[i] > nums[stk.peek()]) {
                k = stk.pop();
            }

            stk.push(i);
        }

        return false;
        
    }
}