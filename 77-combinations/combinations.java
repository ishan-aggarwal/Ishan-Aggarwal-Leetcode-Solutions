class Solution {
    public List<List<Integer>> combine(int n, int k) {
        

        // 1 se n tk ka banana hai
        // same number doobara nahi chaiye
        // maximum numbers k

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int idx = 1;
        helper(ans, temp, idx, n, k);

        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> temp, int idx, int n, int k) {
        // base condition abhi sochte hai...
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // actual logic kya hoga
        for (int i = idx; i <= n; i++) {
            temp.add(i);
            helper(ans, temp, i + 1, n, k - 1);
            temp.remove(temp.size() - 1);
        }
    }
}