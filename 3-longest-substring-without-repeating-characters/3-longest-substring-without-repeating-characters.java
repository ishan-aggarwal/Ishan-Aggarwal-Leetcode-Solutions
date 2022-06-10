class Solution {
    public int lengthOfLongestSubstring(String s) {
        
		Map<Character, Integer> positionMap = new HashMap<>();
        int answer = 0;
		int start = 0;

		for (int end = 0; end < s.length(); ++end) {

			if (positionMap.containsKey(s.charAt(end))) {
				int lastPos = positionMap.get(s.charAt(end));
				start = Math.max(start, lastPos + 1);
			}

			positionMap.put(s.charAt(end), end);
			answer = Math.max(answer, end - start + 1);
		}

		return answer;
    }
}