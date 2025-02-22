class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left <= right) {
            char leftValue = s.charAt(left);
            char rightValue = s.charAt(right);
            if (isAlphanumeric(leftValue) && isAlphanumeric(rightValue)) {
                
                if (leftValue != rightValue) {
                    return false;
                }

                left++;
                right--;

            } else if (isAlphanumeric(leftValue)) {
                right--;
            } else {
                left++;
            }
        }

        return true;
    }

    public boolean isAlphanumeric(char value) {
        if ((value >= 'a' && value <= 'z') || (value >= '0' && value <= '9')) {
            return true;
        }
        return false;
    }
}