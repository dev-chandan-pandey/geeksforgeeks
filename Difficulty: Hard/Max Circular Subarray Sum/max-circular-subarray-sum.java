//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
 public int circularSubarraySum(int[] arr) {
    int n = arr.length;
    int max_sum = Integer.MIN_VALUE, cur_max = 0;
    int min_sum = Integer.MAX_VALUE, cur_min = 0;
    int total_sum = 0;

    for (int i = 0; i < n; i++) {
        cur_max = Math.max(arr[i], cur_max + arr[i]);
        max_sum = Math.max(max_sum, cur_max);

        cur_min = Math.min(arr[i], cur_min + arr[i]);
        min_sum = Math.min(min_sum, cur_min);

        total_sum += arr[i];
    }

    if (max_sum < 0) {
        return max_sum; // All elements are negative
    }

    return Math.max(max_sum, total_sum - min_sum);
}
}
