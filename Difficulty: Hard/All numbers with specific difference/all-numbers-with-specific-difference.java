class Solution {
    
    
      static boolean isGreater(int val, int d) {
        int digitSum = 0, tmp = val;
        while (tmp > 0) {
            digitSum += tmp % 10;
            tmp /= 10;
        }

        return val - digitSum >= d;
    }
    public int getCount(int n, int d) {
        // Minimum number for which difference between 
        // number and sum of digits >= d.
        int mini = n + 1;
        int s = 1, e = n;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            
            if (isGreater(mid, d)) {
                mini = mid;
                e = mid - 1;
            }
            else s = mid + 1;
        }

        // Number of values in range [1, n]
        // will be equal to 
        return n + 1 - mini;
    }
};