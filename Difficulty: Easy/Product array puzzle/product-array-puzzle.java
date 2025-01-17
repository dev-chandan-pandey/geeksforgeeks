//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length, totalProd = 1, zeroCnt = 0;
        int[] res = new int[n];
        for(int i: arr){
            if(i==0){
                zeroCnt++;
            }
            else{
                totalProd*=i;
            } 
        }
        if(zeroCnt > 1){
            return res;
        }
        if(zeroCnt == 1){
            for(int i=0;i<n;i++){
                if(arr[i]==0){
                    res[i]=totalProd;
                }
            }
            return res;
        }
        for(int i=0;i<n;i++){
            res[i] = totalProd/arr[i];
        }
        return res;
    }
}
