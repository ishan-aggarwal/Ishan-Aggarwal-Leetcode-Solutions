class Solution {
    
    // TC - O(2^n) where n is the size of nums
    // there are two possibilities for each of the element
    // either to include it or exclude it
    public List<List<Integer>> subsets(int[] nums) {
        
        
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        generateSubsets (nums, 0, subset, allSubsets);
        return allSubsets;             
    }
    
    public void generateSubsets(int[] nums, int currIndex, List<Integer> aux, List<List<Integer>> allSubsets) {
        
        if (currIndex == nums.length) {
            allSubsets.add(new ArrayList<>(aux));
            return;
        }
        
        aux.add(nums[currIndex]);
        generateSubsets (nums, currIndex + 1, aux, allSubsets);
        
        aux.remove(aux.size() - 1);
        generateSubsets (nums, currIndex + 1, aux, allSubsets);
    }
    
}