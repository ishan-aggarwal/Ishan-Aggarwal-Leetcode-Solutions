class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int l = 0;
        int r = letters.length - 1;
        
        while (l <= r) {
            int mi = l + (r - l) / 2;
            
            if (letters[mi] <= target) {
                l = mi + 1;
            } else {
                r = mi -1;
            }
        }
        
        return letters[l % letters.length];
    }
}