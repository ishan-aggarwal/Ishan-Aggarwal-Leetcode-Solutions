class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        helper(nums, seen, current, ans);
        return ans;
    }

    public void helper(int[] nums, Set<Integer> seen, List<Integer> current, List<List<Integer>> ans) {
        if (nums.length == current.size()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (!seen.contains(element)) {
                seen.add(element);
                current.add(element);
                helper(nums, seen, current, ans);

                current.remove(current.size() - 1);
                seen.remove(element);
            }
        }
    }


}