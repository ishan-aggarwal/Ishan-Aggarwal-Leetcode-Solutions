class Solution {
    
    // based on what is given in the input...
    // if number is 0 return 0...
    // otherwise find mid...
    
    // for perfect square mid * mid == number return mid
    // if mid * mid is less than number than we store in mid in probable answer... and increase left pointer...
    // finally we return our probable answer...
    public int mySqrt(int x) {
        
        if(x == 0) return 0;
        
        int start = 1, end = x/2, ans = 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(mid == x/mid){
                return mid;
            } else if (mid < x/mid){
                ans = mid;
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return ans;
    }
}