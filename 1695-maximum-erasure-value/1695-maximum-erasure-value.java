class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int[] prefixSum = new int[nums.length + 1];

        int maxScore = 0;
        for (int l=0, r=0; r<nums.length; r++) {
            prefixSum[r+1] = prefixSum[r] + nums[r];
            if (lastIndex.containsKey(nums[r])) 
                l = Math.max(l, lastIndex.get(nums[r]) + 1);
            maxScore = Math.max(maxScore, prefixSum[r+1] - prefixSum[l]);
            lastIndex.put(nums[r], r);
        }

        return maxScore;
    }
}