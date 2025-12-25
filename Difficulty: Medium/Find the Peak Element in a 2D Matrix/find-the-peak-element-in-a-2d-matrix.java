class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        // code here
         int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int curr = mat[i][j];
                boolean isPeak = true;

                // check top
                if (i > 0 && mat[i - 1][j] > curr)
                    isPeak = false;

                // check bottom
                if (i + 1 < n && mat[i + 1][j] > curr)
                    isPeak = false;

                // check left
                if (j > 0 && mat[i][j - 1] > curr)
                    isPeak = false;

                // check right
                if (j + 1 < m && mat[i][j + 1] > curr)
                    isPeak = false;

                if (isPeak) {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        res.add(-1);
        return res;
    }
}