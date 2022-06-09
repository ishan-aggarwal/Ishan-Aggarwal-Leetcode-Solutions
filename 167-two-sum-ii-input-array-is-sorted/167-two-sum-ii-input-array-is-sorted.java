class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        Map<Integer, Integer> positionMap = new HashMap<>();
        
        
        for (int i = 0; i < len; i++) {
            if (positionMap.containsKey(target - numbers[i])) {
                return new int[] {positionMap.get(target - numbers[i]), (i+1)};
            }
            positionMap.put(numbers[i], (i+1));
        }
        
        return new int[] {-1, -1};
    }
}