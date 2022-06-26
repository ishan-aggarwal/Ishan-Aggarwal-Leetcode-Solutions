class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int prefixSum[]=new int[n];
        int sum=0;// this will also hold the entire sum
        for(int i=0;i<n;i++){
            sum+=cardPoints[i];
            prefixSum[i]=sum;
        }
        if(k==n)
            return sum;
        int t=n-k;
        int j=0;
        int min=prefixSum[t-1];
        for(int i=t;i<n;i++){
            int diff=prefixSum[i]-prefixSum[j];
            min=Math.min(min,diff);
            j++;
        }
        return sum-min;
    }
}