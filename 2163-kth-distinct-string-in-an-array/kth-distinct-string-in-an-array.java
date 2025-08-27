class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String str : arr) {
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }
        
        for (int i = 0; i < arr.length; i++) {
            String key = arr[i];
            if (freqMap.get(key) == 1 && k == 1) {
                return key;
            } else if (freqMap.get(key) == 1) {
                k--;
            }
        }

        return "";
    }
}