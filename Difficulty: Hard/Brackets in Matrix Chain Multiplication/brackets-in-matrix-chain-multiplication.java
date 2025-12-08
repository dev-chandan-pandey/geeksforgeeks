import java.util.Arrays;

class Solution {
    private String buildOrder(int i, int j, int[][] brackets) {
        if (i == j) {
            char a = (char) ('A' + i - 1);
            return String.valueOf(a);
        }
        return "(" + buildOrder(i, brackets[i][j], brackets) 
                   + buildOrder(brackets[i][j] + 1, j, brackets) + ")";
    }

    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] brackets = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        brackets[i][j] = k;
                    }
                }
            }
        }

        return buildOrder(1, n - 1, brackets);
    }
}
