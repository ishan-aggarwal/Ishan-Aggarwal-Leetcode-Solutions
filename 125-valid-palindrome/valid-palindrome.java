class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (isAlphanumeric(left) && isAlphanumeric(right)) {
                if (left != right) {
                    return false;
                }
                i++;
                j--;
            } else if (isAlphanumeric(left)) {
                j--;
            } else {
                i++;
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}