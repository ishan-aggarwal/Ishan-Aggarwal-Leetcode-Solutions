class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineFreqMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineFreqMap.put(c, magazineFreqMap.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!magazineFreqMap.containsKey(c)) {
                return false;
            }
            magazineFreqMap.put(c, magazineFreqMap.get(c) - 1);
            if (magazineFreqMap.get(c) == 0) {
                magazineFreqMap.remove(c);
            }
        }

        return true;
    }
}