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
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
// java and c++ code is almost same so I am not writing c++ code. Please ask if you have any doubt.
    public int maxWater(int arr[]) {
        // Code Here
        int i=0, j=arr.length-1, ans=0;
        while(i<j){
            int currWater = Math.min(arr[i], arr[j])*(j-i);
            ans=Math.max(ans, currWater);
            if(arr[i]<arr[j]){
                i++;
            }
            else {
                j--;
            }
        }
        return ans;
    }
}