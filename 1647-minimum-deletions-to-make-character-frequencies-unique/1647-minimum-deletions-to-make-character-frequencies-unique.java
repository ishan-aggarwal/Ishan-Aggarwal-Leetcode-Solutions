class Solution {
    
    
// Complexity Analysis

// Here, NN is the length of the given string, and KK is the maximum possible number of distinct characters in s.

// Time complexity: O(N + K^2)O(N+K 
// 2
//  )

// To store the frequencies, we need to traverse the string, which will take O(N)O(N) time. The maximum number of operations will occur when the frequencies for all the KK characters are the same. In that case, for the ith character, we would need to decrement the frequency by i - 1i−1 to make it unique. Hence the total number of operations would be 0 + 1 + 2 + .... + K - 1 = ((K - 1) * K )/20+1+2+....+K−1=((K−1)∗K)/2. Hence, the total time complexity is O(N + K^2)
// Space complexity: O(K)

// We need KK indices in the list frequency to store the frequencies. Also, there can be at most KK unique frequencies, and hence the space required for the HashSet seenFrequencies is O(K). Hence, the space complexity is equal to O(K)O(K).
    
    
    public int minDeletions(String s) {
        // Store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        int deleteCount = 0;
        // Use a set to store the frequencies we have already seen
        HashSet<Integer> seenFrequencies = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            // Keep decrementing the frequency until it is unique
            while (frequency[i] > 0 && seenFrequencies.contains(frequency[i])) {
                frequency[i]--;
                deleteCount++;
            }
            // Add the newly occupied frequency to the set
            seenFrequencies.add(frequency[i]);
        }
        
        return deleteCount;   
    }
    
    // using PQ
    
//     public int minDeletions(String s) {
//         // Store the frequency of each character
//         int[] frequency = new int[26];
//         for (int i = 0; i < s.length(); i++) {
//             frequency[s.charAt(i) - 'a']++;
//         }
        
//         // Add the frequencies to the priority queue
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         for (int i = 0; i < 26; i++) {
//             if (frequency[i] > 0) {
//                 pq.add(frequency[i]);
//             }
//         }
        
//         int deleteCount = 0;
//         while (pq.size() > 1) {
//             int topElement  = pq.remove();
            
//             // If the top two elements in the priority queue are the same
//             if (topElement == pq.peek()) {
//                 // Decrement the popped value and push it back into the queue
//                 if (topElement - 1 > 0) {
//                     pq.add(topElement - 1);
//                 }
//                 deleteCount++;
//             }
//         }
        
//         return deleteCount;
//     }
    
}