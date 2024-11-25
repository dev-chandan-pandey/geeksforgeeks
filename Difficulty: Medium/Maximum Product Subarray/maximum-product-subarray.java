//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int maxProduct(int[] nums) {
        int pref = 1, suff = 1;
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (pref == 0) {
                pref = 1;
            }
            if (suff == 0) {
                suff = 1;
            }

            pref *= nums[i];
            suff *= nums[n - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(pref, suff));
        }

        return maxProduct;
    }
}