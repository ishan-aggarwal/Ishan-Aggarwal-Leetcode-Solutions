class Solution {

    public int minOperations(int[] nums) {
        // List<Integer> s = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for (int a : nums) {
            while (!s.isEmpty() && s.peek() > a) {
                // s.remove(s.size() - 1);
                s.pop();
            }
            if (a == 0) continue;
            if (s.isEmpty() || s.peek() < a) {
                res++;
                s.add(a);
            }
        }
        return res;
    }
}