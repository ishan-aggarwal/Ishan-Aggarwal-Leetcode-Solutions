class Solution {
    public boolean isPossible(int[] target) {

        long sum =0;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        
        for(int t:target){
            sum += t;
            maxHeap.offer(t);
        }
        
        while(sum>1 && maxHeap.peek() > sum/2){
            int max = maxHeap.poll();
            sum-=max;
            if(sum<=1)
                return sum==0 ? false : true;
            maxHeap.add(max % (int)sum);
            sum += max % sum;
        }

        return sum == target.length;
        
    }
}