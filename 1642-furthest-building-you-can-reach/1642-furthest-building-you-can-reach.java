class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        Queue<Integer> lads = new PriorityQueue();
        for (int i = 0; i < heights.length; ++i) {
            if (i == heights.length-1)
                return i;
            
            if (heights[i] >= heights[i+1])
                continue;
            
            int b = heights[i+1] - heights[i];
            if (ladders > 0) {
                lads.add(b);
                --ladders;
                continue;
            }
            
            if (!lads.isEmpty() && lads.peek() < b) {
                lads.add(b);
                b = lads.poll();
            }
            
            bricks -= b;
            if (bricks < 0)
                return i;
        }
        
        return 0;
        
    }
}