class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character, String> mapping = new HashMap<>();
        Set<String> seen = new HashSet<>();

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (!mapping.containsKey(c)) {
                if (seen.contains(word)) {
                    return false;
                }
                mapping.put(c, word);
                seen.add(word);
            } else {
                String mappedValue = mapping.get(c);
                if (!mappedValue.equals(word)) {
                    return false;
                }
            }
        }
        return true;
    }
}