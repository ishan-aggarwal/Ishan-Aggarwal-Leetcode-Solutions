class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    if (words[j].contains(words[i])) {
                        set.add(words[i]);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}