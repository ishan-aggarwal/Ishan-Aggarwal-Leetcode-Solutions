class Solution {
    public String longestCommonPrefix(String[] strs) {

        int n = strs.length;
        StringBuilder ans = new StringBuilder();
        
        // first string
        String first = strs[0];

        // iterate over entire first string
        for (int j = 0; j < first.length(); j++) {

            char c = first.charAt(j);
            boolean isSame = true;
            
            // iterate over remaining strings 
            for (int i = 1; i < n; i++) {
                String other = strs[i];
                if (j >= other.length()) {
                    isSame = false;
                    break;
                }
                char o = other.charAt(j);
                if (c != o) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                ans.append(c);
            } else {
                break;
            }
        }
        return ans.toString();
    }
}