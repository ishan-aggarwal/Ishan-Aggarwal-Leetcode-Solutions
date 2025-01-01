class Solution {
    public int maxScore(String s) {

        
        int ones = 0;
        // count total number of ones in the input string 
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ones++;
            }
        }

        int ans = 0;
        int zeros = 0;
        // do a pass from left to right
        // check if s[i] is zero, than increase zeros count
        // else decrease the ones count
        // calculate max ans at each step
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                zeros++;
            } else {
                ones--;
            }

            ans = Math.max(ans, zeros + ones);
        }
        return ans;
    }
}