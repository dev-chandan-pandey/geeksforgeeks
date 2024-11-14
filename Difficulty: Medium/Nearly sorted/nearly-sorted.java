//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
// class Solution {
//     // Non-static method, so you need to call it on an instance of the class
//     public void nearlySorted(int[] arr, int k) {
//         // code
//     }
// }

class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add the first k+1 elements to the min heap
        for (int i = 0; i <= k; i++) {
            pq.offer(arr[i]);
        }

        // Iterate through the remaining elements
        for (int i = k + 1; i < arr.length; i++) {
            // Pop the smallest element from the heap and add it to the array
            arr[i - k - 1] = pq.poll();

            // Add the current element to the heap
            pq.offer(arr[i]);
        }

        // Pop the remaining elements from the heap and add them to the end of the array
        int index = arr.length - k - 1;
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // Create an instance of the Solution class
            Solution obj = new Solution();
            // Call nearlySorted on the instance
            obj.nearlySorted(arr, k);

            // Print the sorted array
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends