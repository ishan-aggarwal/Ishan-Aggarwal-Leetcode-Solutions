class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (char c : magazine.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        for (char c : ransomNote.toCharArray()) {
            if (freqMap.get(c) == null) {
                return false;
            } else if (freqMap.get(c) > 1) {
                freqMap.put(c, freqMap.get(c) - 1);
            } else {
                freqMap.remove(c);
            }
        }
        return true;
        
    }
}