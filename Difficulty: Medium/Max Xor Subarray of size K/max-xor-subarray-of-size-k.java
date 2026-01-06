class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
          int n = arr.length;
        int currXor = 0;

        // compute XOR of the first window
        for (int i = 0; i < k; i++) {
            currXor ^= arr[i];
        }

        int maxXor = currXor;

        // slide the window and update XOR
        for (int i = k; i < n; i++) {
            // include new element
            currXor ^= arr[i];    
            
            // remove leftmost element
            currXor ^= arr[i - k];     

            // update maximum
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
}
