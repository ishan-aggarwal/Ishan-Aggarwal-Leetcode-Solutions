class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] result = new int[length * 2];
        for (int i = 0; i < length; i++) {
            result[i] = nums[i];
            result[length + i] = nums[i];
        }
        return result;
    }
}