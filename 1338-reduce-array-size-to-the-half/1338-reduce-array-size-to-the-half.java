class Solution {
    public int minSetSize(int[] arr) {
        
        // Do the counting with a HashMap.
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int num : arr) {
            if (!countsMap.containsKey(num)) {
                countsMap.put(num, 1);
                continue;
            }
            countsMap.put(num, countsMap.get(num) + 1);
        }
        
        // Reverse sort a list of the Map values.
        List<Integer> counts = new ArrayList<>(countsMap.values());
        Collections.sort(counts);
        Collections.reverse(counts);
        
        // Remove numbers until at least half are removed.
        int numbersRemovedFromArr = 0;
        int setSize = 0;
        for (int count : counts) {
            numbersRemovedFromArr += count;
            setSize += 1;   
            if (numbersRemovedFromArr >= arr.length / 2) {
                break;
            }
        }
        
        return setSize;
    }
}