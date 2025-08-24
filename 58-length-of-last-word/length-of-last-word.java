class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        int n = words.length;
        return words[n - 1].length();
    }
}