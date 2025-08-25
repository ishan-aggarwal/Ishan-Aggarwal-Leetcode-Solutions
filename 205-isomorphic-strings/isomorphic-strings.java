class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        
        if (sLength != tLength) {
            return false;
        }

        Map<Character, Character> mappings = new HashMap<>();
        Set<Character> mappedValues = new HashSet<>();

        for (int i = 0; i < sLength; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (!mappings.containsKey(c1)) {
                if (mappedValues.contains(c2)) {
                    return false;
                }
                mappings.put(c1, c2);
                mappedValues.add(c2);
            } else {
                if (mappings.get(c1) != c2) {
                    return false;
                }
            }
        }
        return true;
    }
}