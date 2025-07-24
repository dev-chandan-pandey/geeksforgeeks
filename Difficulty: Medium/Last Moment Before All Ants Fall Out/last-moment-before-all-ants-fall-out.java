class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int maxTime = 0;
        for (int p : left) maxTime = Math.max(maxTime, p);
        for (int p : right) maxTime = Math.max(maxTime, n - p);
        return maxTime;
    }
}