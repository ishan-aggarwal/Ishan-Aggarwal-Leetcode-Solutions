class Solution {
    public int[] minOperations(String boxes) {
        
        // Appraoch:1 Optimised Approach
        int n = boxes.length();
        int[] distances = new int[n];

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int count = boxes.charAt(0) == '1' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + count;
            count += boxes.charAt(i) == '1' ? 1 : 0;
        }
        //System.out.println(Arrays.toString(leftSum));

        count = boxes.charAt(n -1) == '1' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + count;
            count += boxes.charAt(i) == '1' ? 1 : 0;
        }
        //System.out.println(Arrays.toString(rightSum));

        for (int i = 0; i < n; i++) {
            distances[i] = leftSum[i] + rightSum[i];
        }
        
        return distances;


        // Appraoch:2 done by the brute force way
        // int n = boxes.length();
        // int[] result = new int[n];
        // Set<Integer> ballsPresent = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     int val = boxes.charAt(i) - '0'; // 0  or 1
        //     if (val == 1) {
        //         ballsPresent.add(i);
        //     }
        // }

        // for (int i = 0; i < n; i++) {
        //     for (int index : ballsPresent) {
        //         result[i] += Math.abs(i - index);
        //     }
        // }
        
        // return result;
    }
}