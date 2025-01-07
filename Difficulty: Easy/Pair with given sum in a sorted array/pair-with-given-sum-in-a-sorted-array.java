//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int ans=0, st=0, end=arr.length-1;
        while(st<end){
            int currSum = arr[st]+arr[end];
            if(currSum>target){
                end--;
            }
            else if(currSum<target){
                st++;
            }
            else {
                int e1 = arr[st], e2=arr[end], c1=0, c2=0;
                while(st<=end && arr[st] == e1){
                    st++;
                    c1++;
                }
                while(st<=end && arr[end] == e2){
                    end--;
                    c2++;
                }
                if(e1 == e2){
                    ans+=(c1*(c1-1))/2;
                }
                else {
                    ans+=c1*c2;
                }
            }
        }
        return ans;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends