class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;

        // iterate through s and t using desired pointers
        while (sPointer < s.length() && tPointer < t.length()) {

            // now match the character of s and t.
            // If they are equal, move the sPointer forward.
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }

            // tPointer should always be moved forward
            tPointer++;
        }

        // Return true if sPointer has reached the end of s,
        return sPointer == s.length();
    }
}