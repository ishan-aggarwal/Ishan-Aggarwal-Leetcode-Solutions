class Solution {
    public int[] minOperations(String boxes) {
        
        int n = boxes.length();
        int[] result = new int[n];
        Set<Integer> ballsPresent = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int val = boxes.charAt(i) - '0'; // 0  or 1
            if (val == 1) {
                ballsPresent.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int index : ballsPresent) {
                result[i] += Math.abs(i - index);
            }
        }
        
        return result;
    }
}