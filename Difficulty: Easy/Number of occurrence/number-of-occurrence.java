//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int lo = 0, hi = arr.length-1, st = -1, end = -1;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if(arr[mid] >= target){
                st = mid;
                hi=mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        if(st == -1 || arr[st] != target)
            return 0;
        // System.out.println(st);
        lo = 0;
        hi = arr.length-1;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if(arr[mid] <= target){
                end = mid;
                lo=mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        if(end == -1  || arr[st] != target)
        return 0;
        return end - st +1;
    }
}
