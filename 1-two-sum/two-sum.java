class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int need = target - val;
            if (indexMap.containsKey(need)) {
                int otherIndex = indexMap.get(need);
                return new int[] {otherIndex, i};
            }
            indexMap.put(val, i);
        }

        return new int[] {-1, -1};
    }
}