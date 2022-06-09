class Solution {
    public int[] twoSum(int[] numbers, int target) {
//         int len = numbers.length;
//         Map<Integer, Integer> positionMap = new HashMap<>();
        
        
//         for (int i = 0; i < len; i++) {
//             if (positionMap.containsKey(target - numbers[i])) {
//                 return new int[] {positionMap.get(target - numbers[i]), (i+1)};
//             }
//             positionMap.put(numbers[i], (i+1));
//         }
        
//         return new int[] {-1, -1};
        

        int n = numbers.length;
        
        for (int i = 0, j = n - 1; i < j;) {
            int sum = numbers[i] + numbers[j];
            if ( sum == target) {
                return new int[] {i+1, j+1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        
        return new int[] {};
    }
}