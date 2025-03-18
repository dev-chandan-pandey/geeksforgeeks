//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
     static Boolean[][] dp;
     static boolean equalPartition(int arr[]) {
         // code here
         int sum = Arrays.stream(arr).sum();
         if(sum % 2 != 0) return false;
         int x = sum / 2;
         dp = new Boolean[arr.length][x+1];
         return helper(0, arr, x);
     }
     static boolean helper(int ind, int[] arr, int sum){
         if(ind == arr.length){
             return sum == 0 ? true : false;
         }
         if(dp[ind][sum] != null) return dp[ind][sum];
         boolean res = false;
         if(arr[ind] <= sum){
             res |= helper(ind+1, arr, sum - arr[ind]);
         }
         res |= helper(ind+1, arr, sum);
         return dp[ind][sum] = res;
     }
 }