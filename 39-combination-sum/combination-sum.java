class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int idx = 0;
        helper(ans, current, idx, candidates, target);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> current, int idx, int[] candidates, int target) {

        // base condition to include the current solution into answer
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // base condition to return as no further answer can be found on this path
        if (idx == candidates.length || target < 0) {
            return;
        }

        // actual logic 
        int element = candidates[idx];
        // do operation
        // include element
        current.add(element);
        helper(ans, current, idx, candidates, target - element); // recurse

        // undo operation
        // remove last added element
        current.remove(current.size() - 1);
        helper(ans, current, idx + 1, candidates, target);
    }
}