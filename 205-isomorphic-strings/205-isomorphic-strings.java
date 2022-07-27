class Solution {
    
    private String transformString(String s) {
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            
            if (!indexMapping.containsKey(c1)) {
                indexMapping.put(c1, i);
            }
            
            builder.append(Integer.toString(indexMapping.get(c1)));
            builder.append(" ");
        }
        return builder.toString();
    }
    
    public boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }
    
    
//     public boolean isIsomorphic(String s, String t) {
//         int[] mappingDictStoT = new int[256];
//         Arrays.fill(mappingDictStoT, -1);
        
//         int[] mappingDictTtoS = new int[256];
//         Arrays.fill(mappingDictTtoS, -1);
        
//         for (int i = 0; i < s.length(); ++i) {
//             char c1 = s.charAt(i);
//             char c2 = t.charAt(i);
            
//             // Case 1: No mapping exists in either of the dictionaries
//             if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
//                 mappingDictStoT[c1] = c2;
//                 mappingDictTtoS[c2] = c1;
//             }
            
//             // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
//             // it doesn't match in either of the dictionaries or both 
//             else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
//                 return false;
//             }
//         }
        
//         return true;        
//     }
}