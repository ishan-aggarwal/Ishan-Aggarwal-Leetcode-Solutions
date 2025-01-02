class Solution {

    private static final Map<Character, String> map = new HashMap<>();

    static {
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        helper(ans, "", 0, digits);
        return ans;
    }

    private void helper(List<String> ans, String current, int idx, String digits) {
        if (idx == digits.length()) {
            ans.add(current);
            return;
        }
        char ch = digits.charAt(idx);
        String mappedValue = map.get(ch);
        for (char c : mappedValue.toCharArray()) {
            helper(ans, current + c, idx+1, digits);
        }
    }
}