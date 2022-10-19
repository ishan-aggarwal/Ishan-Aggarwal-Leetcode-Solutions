class Solution {
    
    // Steps:
    // 1. Count the frequency of each word and store the records by a HashMap cnt. O(N)
    // 2. Define the sorting order as what the problem indicates (by frequencies from high to low, and then from lexicographically smaller ones     // to larger ones when we meet a tie in frequency) and sort the entire list of all words. O( N log N)
    // 3. Only return the first k words as the returned result.

    /*
        Time Complexity: O(Nlog⁡N). We count the frequency of each word in O(N) time, and then we sort the given words in O(NlogN) time.
        Space Complexity: O(N), the space used to store frequencies in a HashMap and return a slice from a sorted list of length O(N).
    */
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList<>(cnt.keySet());
        Collections.sort(candidates,
                (w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? w1.compareTo(w2) : cnt.get(w2) - cnt.get(w1));
        return candidates.subList(0, k);
    }
}