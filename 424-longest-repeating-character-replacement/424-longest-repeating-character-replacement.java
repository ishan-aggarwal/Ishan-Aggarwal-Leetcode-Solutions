class Solution {
    public int characterReplacement(String s, int k) {
        
       //base case
        if (s.length() == k || k - 1 == s.length()) {
            return s.length();
        }

        int left=0, ans=0, maxFreqChar = 0;
        int[] fa = new int[26];

        for (int right = 0; right < s.length(); right++) {
            fa[s.charAt(right) - 'A']++;
            maxFreqChar = Math.max(maxFreqChar, fa[s.charAt(right) - 'A']);
            //length of window - total frequency of highest occuring character = k
            if ((right - left + 1) - maxFreqChar > k) {
                fa[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}