//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
     public void sort012(int[] arr) {
        // code here
        int beg=0, end=arr.length-1, i=0;
        while(i<=end){
            if(arr[i]==0){
                swap(arr,i, beg);
                beg++;
                i++;
            }
            else if(arr[i]==2){
                swap(arr, i, end);
                end--;
            }
            else {
                i++;
            }
        }
    }
    static void swap(int[] arr, int i, int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends