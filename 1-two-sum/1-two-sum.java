class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> elementPositionMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (elementPositionMap.containsKey(target - nums[i])) {
                
                int otherPosition = elementPositionMap.get(target - nums[i]);
                return new int[] {i, otherPosition};
                
            }
            elementPositionMap.put(nums[i], i);
        }
        
        return new int[] {};
        
    }
}