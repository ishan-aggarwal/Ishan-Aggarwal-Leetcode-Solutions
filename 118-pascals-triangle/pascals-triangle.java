class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = List.of(1);
        ans.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = ans.get(i - 1);

            List<Integer> current = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    current.add(1);
                } else {
                    int prev1 = prev.get(j);
                    int prev2 = prev.get(j - 1);
                    current.add(prev1 + prev2);
                }
            }
            ans.add(current);
        }
        return ans;
    }
}