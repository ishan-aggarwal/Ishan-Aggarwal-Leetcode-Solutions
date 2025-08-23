class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int element : nums) {
            set.add(element);
        }
        return set.size() != nums.length;
    }
}