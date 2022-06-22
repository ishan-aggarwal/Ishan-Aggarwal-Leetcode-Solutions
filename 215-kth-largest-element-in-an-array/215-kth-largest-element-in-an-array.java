class Solution {
    public int findKthLargest(int[] nums, int k) {
        // default order is ascending in PriorityQueue which is natural ordering 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            // construct a min heap
            pq.add(nums[i]);
            if (pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}