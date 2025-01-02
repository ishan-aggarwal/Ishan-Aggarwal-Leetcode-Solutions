class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int idx = 0;
        helper(ans, temp, idx, nums);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> temp, int idx, int[] nums) {
        
        if (idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // actual logic
        int ele = nums[idx];
        // pick element
        // do operation
        temp.add(ele);
        // recurse
        helper(ans, temp, idx + 1, nums);
        // undo operation
        temp.remove(temp.size() - 1);
        helper(ans, temp, idx + 1, nums);


    }
}