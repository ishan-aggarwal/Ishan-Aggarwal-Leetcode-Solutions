class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        solve(0, nums, curr, ans);
        
        return ans;
    }
    
    private void solve(int idx, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        
        if (idx == nums.length) {
            if (!ans.contains(curr)) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        
        
        curr.add(nums[idx]);
        solve(idx + 1, nums, curr, ans);
        
        curr.remove(curr.size() - 1);
        solve(idx + 1, nums, curr, ans);        
    }
}