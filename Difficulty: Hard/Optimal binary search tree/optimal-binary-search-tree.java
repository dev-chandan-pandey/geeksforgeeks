class Solution {
     //function to get sum of
    // array elements freq[i] to freq[j]
    static int sum(int[] freq, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++)
            s += freq[k];
        return s;
    }
    static int optCost(int[] freq, int i, int j, int[][] dp) {

        // Base cases
        if (j < i)
            return 0;
        if (j == i)
            return freq[i];

        if (dp[i][j] != -1)
            return dp[i][j];

        // Get sum of freq[i], freq[i+1], ... freq[j]
        int fsum = sum(freq, i, j);
        int minCost = Integer.MAX_VALUE;

        // One by one consider all elements
        // as root and recursively find cost
        // of the BST
        for (int r = i; r <= j; r++) {
            int cost = optCost(freq, i, r - 1, dp) + optCost(freq, r + 1, j, dp);
            if (cost < minCost)
                minCost = cost;
        }

        // Return minimum value
        return dp[i][j] = minCost + fsum;
    }
    public int minCost(int keys[], int freq[]) {
        // code here
          int n = keys.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return optCost(freq, 0, n - 1, dp);
    }
}
