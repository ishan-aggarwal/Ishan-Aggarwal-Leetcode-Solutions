class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int v : freqMap.values()) {

            if (v > maxOdd && v % 2 == 1) {
                maxOdd = v;
            }

            if (v < minEven && v % 2 == 0) {
                minEven = v;
            }
        }

        return maxOdd - minEven;
    }
}