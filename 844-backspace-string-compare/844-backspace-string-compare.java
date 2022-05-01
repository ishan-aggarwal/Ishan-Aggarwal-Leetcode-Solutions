class Solution {
    
    // Approach 1.
    // Time Complexity: O(M + N), where M, NM,N are the lengths of S and T respectively
    // Space Complexity: O(M + N) for the two stacks that we have created
//     public boolean backspaceCompare(String s, String t) {
//         return build(s).equals(build(t));
//     }

//     public String build(String S) {
//         Stack<Character> ans = new Stack();
//         for (char c: S.toCharArray()) {
//             if (c != '#')
//                 ans.push(c);
//             else if (!ans.empty())
//                 ans.pop();
//         }
//         return String.valueOf(ans);
//     }

    
    // Approach 2.
    // Time Complexity: O(M + N), where M, NM,N are the lengths of S and T respectively
    // Space Complexity: O(1)
    // Observation: We need to iterate over the strings from back to see the occurences of backspace character
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            // if (((i == 0) && (j != 0)) || ((i != 0) && (j == 0)))
            //     return false;
            i--; j--;
        }
        return true;
    }
    
}