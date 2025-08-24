class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (positionMap.containsKey(other)) {
                return new int[] {positionMap.get(other), i};
            }
            positionMap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}