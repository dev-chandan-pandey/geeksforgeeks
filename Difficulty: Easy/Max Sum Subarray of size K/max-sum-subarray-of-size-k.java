class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
         int n = arr.length;
        int[] prefix = new int[n + 1];

        // build prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int maxSum = 0;

        // compute sum of each subarray of size k 
        // using prefix array
        for (int i = 0; i <= n - k; i++) {
            int j = i + k - 1;
            int currSum = prefix[j + 1] - prefix[i];

            // update maximum sum
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}