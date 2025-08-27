class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        int maxEven = Integer.MIN_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for (int v : freqMap.values()) {

            if (v > maxEven && v % 2 == 0) {
                maxEven = v;
            } else if (v > maxOdd && v % 2 == 1) {
                maxOdd = v;
            }

            if (v < minEven && v % 2 == 0) {
                minEven = v;
            } else if (v < minOdd && v % 2 == 1) {
                minOdd = v;
            }
        }

        // int max1 = Math.abs(maxEven - minOdd);
        // int max2 = Math.abs(maxOdd - minEven);

        // return Math.max(max1, max2);

        return maxOdd - minEven;
    }
}