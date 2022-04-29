class Solution {
    public void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        
        if (index == nums.length) {
            List<Integer> eachPermute = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                eachPermute.add(nums[i]);
            }
            ans.add(new ArrayList<>(eachPermute));
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            recurPermute(index + 1, nums, ans);
            swap(index, i, nums);
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;    
    }
}