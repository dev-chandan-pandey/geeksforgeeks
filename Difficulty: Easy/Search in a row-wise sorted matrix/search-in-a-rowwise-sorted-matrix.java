//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchRowMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in row-column sorted matrix.
    // java and c++ code is almost same so I am not writing c++ code. Please ask if you have any doubt.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        for(int i =0;i< mat.length;i++){
            int lo = 0, hi = mat[0].length-1;
            while(lo<=hi){
                int mid = (lo+hi)/2;
                if(mat[i][mid] == x)
                    return true;
                if(mat[i][mid] < x){
                    lo = mid +1;
                }
                else {
                    hi = mid-1;
                }
            }
        }
        return false;
    }
}
