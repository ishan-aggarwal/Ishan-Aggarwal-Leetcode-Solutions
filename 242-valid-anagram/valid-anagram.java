class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) - 1);
                if (sMap.get(c) == 0) {
                    sMap.remove(c);
                }
            } else {
                sMap.put(c, sMap.getOrDefault(c, 0) - 1);
            }
        }
        return sMap.size() == 0;
    }
}