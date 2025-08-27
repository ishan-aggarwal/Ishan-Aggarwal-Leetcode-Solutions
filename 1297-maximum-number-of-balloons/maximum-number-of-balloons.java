class Solution {
    public int maxNumberOfBalloons(String text) {
        // balloon
        // Map<Character, Integer> map = new HashMap<>();
        // for (char c : text.toCharArray()) {
        //     map.put(c, map.getOrDefault(c, 0) + 1);
        // }
        // int bFreq = map.getOrDefault('b', 0);
        // int aFreq = map.getOrDefault('a', 0);
        // int nFreq = map.getOrDefault('n', 0);

        // int min = Math.min(nFreq, Math.min(bFreq, aFreq));

        // int lFreq = map.getOrDefault('l', 0);
        // int oFreq = map.getOrDefault('o', 0);

        // int other = Math.min(lFreq, oFreq) / 2;

        // return Math.min(min, other);

        int[] freq = new int[26];
        for (char c : text.toCharArray()) freq[c - 'a']++;
        int count = Math.min(freq['b'-'a'], Math.min(freq['a'-'a'], Math.min(freq['n'-'a'], Math.min(freq['l'-'a']/2, freq['o'-'a']/2))));
        return count;
    }
}