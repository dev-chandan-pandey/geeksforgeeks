//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int n = arr.length;
         int largest = -1; // Initialize largest and second largest to -1
        int sLargest = -1;

        for (int i = 0; i < n; ++i) {
            // If current element is greater than largest, update both largest and second largest
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            }
            // If current element is in between largest and second largest, update second largest
            else if (arr[i] < largest && arr[i] > sLargest) {
                sLargest = arr[i];
            }
        }

        return sLargest;
    }
}

