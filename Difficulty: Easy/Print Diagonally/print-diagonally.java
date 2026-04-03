class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        ArrayList<Integer> res = new ArrayList<>();
        if (mat == null || mat.length == 0) return res;

        int n = mat.length;      // Number of rows
        int m = mat[0].length;   // Number of columns

        // There are (n + m - 1) total diagonals
        // Part 1: Diagonals starting from the first row (0, j)
        for (int j = 0; j < m; j++) {
            int r = 0;
            int c = j;
            while (r < n && c >= 0) {
                res.add(mat[r][c]);
                r++;
                c--;
            }
        }

        // Part 2: Diagonals starting from the last column (i, m-1)
        // Start from i = 1 to avoid repeating the top-right corner
        for (int i = 1; i < n; i++) {
            int r = i;
            int c = m - 1;
            while (r < n && c >= 0) {
                res.add(mat[r][c]);
                r++;
                c--;
            }
        }

        return res;
    }
}

