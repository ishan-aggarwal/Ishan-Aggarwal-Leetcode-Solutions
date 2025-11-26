class Solution {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        int l = 0, r = 0;
        int n = s.length();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        while (r < n) {
            char c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            while (compareMaps(sMap, tMap)) {
                int windowLength = r - l + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = l;
                    end = r;
                }
                char leftChar = s.charAt(l);
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                if (sMap.get(leftChar) == 0) {
                    sMap.remove(leftChar);
                }
                l++;
            }
            // increase r every time
            r++;
        }

        return start == -1 ? "" : s.substring(start, end + 1);
    }

    private boolean compareMaps(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char c = entry.getKey();
            int expectedFreq = entry.getValue();
            if (!sMap.containsKey(c) || sMap.get(c) < expectedFreq) {
                return false;
            }
        }
        return true;
    }
}