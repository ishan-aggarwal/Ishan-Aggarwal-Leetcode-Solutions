class Solution {
    
    // There could be multiple ways 
    // 1. sort the array and just return the element at (N-k) index
    // but the time complexity can go up to O(N log N)
    
    
    // 2. so binary search is another approach which reduces from O(N log N) to O(N log(range))
    
    // 3. Most optimal solution would be if k is small, then we can simply have a min heap
    // which is the default priority queue
    // and keeps on adding the elements to PQ and maintain only k elements at a time...
    // and finally return the peek of the queue.
    
    // constructs Min heap
    // O (N * log (k))
    public int findKthLargest(int[] nums, int k) {
        
        // default order is ascending in PriorityQueue which is natural ordering 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        return pq.peek();    
    }
        
//     // Binary search approach
//     // overall TC - O(N * log(range))
//     public int findKthLargest(int[] nums, int k) {
//         int n = nums.length - 1;
//         int x = n - k + 1;
//         int ans = -1;
        
//         int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
//         // TC - O(N)
//         for (int i = 0; i < nums.length; ++i) {
//             min = Math.min(min, nums[i]);
//             max = Math.max(max, nums[i]);
//         }
        
//         int l = min, r = max;
        
//         // TC - O (log(range)) where range -> (max - min)
//         while (l <= r) {
//             int mid = l + (r - l) / 2;
//             int count = countSmallElements(nums, mid); // step takes O(N) time
//             if (count <= x) {
//                 ans = mid;
//                 l = mid + 1;
//             } else {
//                 r = mid - 1;
//             }
//         }
        
//         return ans;
//     }
    
//     private int countSmallElements(int[] nums, int ele) {
//         int count = 0;
//         for (int x : nums) {
//             if (x < ele) {
//                 count++;
//             }
//         }
//         return count;
//     }
}