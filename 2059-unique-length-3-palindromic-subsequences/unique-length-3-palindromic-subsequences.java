class Solution {
    public int countPalindromicSubsequence(String s) {
        
        // // a -> 0, 1

        // // I want to find the start and end position of a same character in the string s
        // // once I have find that than I need to find all unique characters between those two indices 
        // // and add that to my ans

        // // aaaaa

        // Set<Character> letters = new HashSet<>();
        // for (Character c : s.toCharArray()) {
        //     letters.add(c);
        // }
        // // maximum 26 unique letters would be added to the above set

        // int total = 0;
        // for (Character ch : letters) {
        //     int i = -1, j = 0;
        //     for (int k = 0; k < s.length(); k++) {
        //         if (ch == s.charAt(k)) {
        //             if (i == -1) {
        //                 i = k;
        //             }
        //             j = k;
        //         }

        //         Set<Character> betweenLettersSet = new HashSet<>();
        //         for (int l = i + 1; l < j; l++) {
        //             betweenLettersSet.add(s.charAt(l));
        //         }
        //         total += betweenLettersSet.size();
        //     }
        // }

        // return total;

        Set<Character> letters = new HashSet();
        for (Character c: s.toCharArray()) {
            letters.add(c);
        }
        
        int ans = 0;
        for (Character letter : letters) {
            int i = -1;
            int j = 0;
            
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == letter) {
                    if (i == -1) {
                        i = k;
                    }
                    
                    j = k;
                }
            }
            
            Set<Character> between = new HashSet();
            for (int k = i + 1; k < j; k++) {
                between.add(s.charAt(k));
            }
            
            ans += between.size();
        }
        
        return ans;

    }
}