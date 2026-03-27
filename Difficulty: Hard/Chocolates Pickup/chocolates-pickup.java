class Solution {
    public int solve(int i, int j1, int j2, int n, int m, int[][] grid, Integer[][][] dp) {
        // 1. Boundary Check
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return (int) -1e9;
        }

        // 2. Base Case: Last Row
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        // 3. Memoization
        if (dp[i][j1][j2] != null) return dp[i][j1][j2];

        // 4. Explore all 9 move combinations
        int maxi = (int) -1e9;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                int res = solve(i + 1, j1 + dj1, j2 + dj2, n, m, grid, dp);
                maxi = Math.max(maxi, value + res);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    public int maxChocolate(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // Using Integer object array to easily check for null (unvisited states)
        Integer[][][] dp = new Integer[n][m][m];
        
        // Robot 1 starts at (0, 0), Robot 2 starts at (0, m-1)
        return solve(0, 0, m - 1, n, m, grid, dp);
    }
}
