//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // code in java and c++ is almost same so I am not writing c++ code. Please ask if you have any doubt.
    public int longestUniqueSubstr(String s) {
        // code here
        int[] freq = new int[26];
        int i=0, j=0, ans=0;
        while(j<s.length()){
            int ch = s.charAt(j)-'a';
            if(freq[ch]>0){
                ans=Math.max(ans, j-i);
                while(i<j && s.charAt(i)!=s.charAt(j)){
                    freq[s.charAt(i)-'a']=0;
                    i++;
                }
                i++;
            }
            else {
                freq[ch]++;
            }
            j++;
        }
        ans=Math.max(ans, j-i);
        return ans;
    }
}