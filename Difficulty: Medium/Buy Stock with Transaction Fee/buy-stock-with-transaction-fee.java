class Solution {
    public int maxProfit(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        
        int n = arr.length;
        // profit if we are holding a stock (initialized to buying on day 0)
        long hold = -arr[0];
        // profit if we are not holding any stock
        long free = 0;
        
        for (int i = 1; i < n; i++) {
            // Either keep holding or buy a new stock using current 'free' profit
            hold = Math.max(hold, free - arr[i]);
            // Either stay 'free' or sell current stock (deducting fee 'k')
            free = Math.max(free, hold + arr[i] - k);
        }
        
        return (int) free;
    }
}
