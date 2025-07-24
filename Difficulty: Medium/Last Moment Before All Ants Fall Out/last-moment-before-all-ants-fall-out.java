class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeft = Arrays.stream(left).max().orElse(0);
        int maxRight = n - Arrays.stream(right).min().orElse(n);
        return Math.max(maxLeft, maxRight);
    }
}