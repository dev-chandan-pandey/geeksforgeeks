//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

 class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // Check if the lengths of the strings are equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create an array of size 26 to store character frequencies
        int[] charCount = new int[26];

        // Increment the count of characters in s1
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Decrement the count of characters in s2
        for (char c : s2.toCharArray()) {
            charCount[c - 'a']--;
        }

        // If any frequency is not zero, the strings are not anagrams
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}