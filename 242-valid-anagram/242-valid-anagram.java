class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> freqCount = new HashMap<>();
        
        for (Character c : s.toCharArray()) {
            freqCount.put(c, freqCount.getOrDefault(c, 0) + 1);
        }
        
        for (Character c : t.toCharArray()) { 
            if (!freqCount.containsKey(c)) {
                return false;
            }
            
            freqCount.put(c, freqCount.get(c) - 1);
            if (freqCount.get(c) == 0) {
                freqCount.remove(c);
            }
        }
        
        return freqCount.size() == 0 ? true : false;
    }
}