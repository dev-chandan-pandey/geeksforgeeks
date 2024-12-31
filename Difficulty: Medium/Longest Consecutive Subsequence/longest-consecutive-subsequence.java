//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        Set<Integer> hst = new HashSet();
        for(int i: arr){
            hst.add(i);
        }
        int ans = 0;
        for(int i: arr){
            int curr=0, tmp=i, tmp2=i-1;
            if(hst.contains(i)){
                while(hst.contains(tmp)){
                    curr++;
                    hst.remove(tmp);
                    tmp++;
                }
                while(hst.contains(tmp2)){
                    curr++;
                    hst.remove(tmp2);
                    tmp2--;
                }
            }
            ans=Math.max(ans, curr);
        }
        return ans;
    }
}