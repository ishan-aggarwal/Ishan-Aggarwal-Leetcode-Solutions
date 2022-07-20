class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), new ArrayList<>());
            }
            hm.get(s.charAt(i)).add(i);
        }
        int count = 0;
        for(String str : words) {
            int index = -1;
            int i;
            for(i = 0; i < str.length(); i++) {
                boolean flag = true;
                if(!hm.containsKey(str.charAt(i))) {
                    break;
                }
                for(int j : hm.get(str.charAt(i))) {
                    if(j > index) {
                        index = j;
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    break;
                }
            }
            if(i == str.length()) {
                count++;
            }
        }
        return count;

    }
}