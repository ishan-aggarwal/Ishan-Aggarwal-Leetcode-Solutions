class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] rMax = new int[n]; // Stores max value from arr[i] to arr[n-1]
        
        // rMax[n-1] is just arr[n-1] (max of one element)
        rMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], arr[i]);
        }
        // Now, rMax[i] = max(arr[i], arr[i+1], ..., arr[n-1])
        
        int[] ans = new int[n]; // Final answer array
        ans[n - 1] = -1; // Last element is always -1
        
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = rMax[i + 1]; // Assign greatest element to right
        }
        return ans;
    }
}
