//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        solve(mat, 0, 0);
    }
    static boolean solve(int[][] mat, int i, int j){
        if(i==9){
            return true;
        }
        int nextI=0, nextJ=0;
        if(j==8){
           nextI=i+1;
           nextJ=0;
        }
        else {
            nextI=i;
            nextJ=j+1;
        }
        if(mat[i][j]!=0){
            return solve(mat, nextI, nextJ);
        }
        else {
            for(int val=1;val<=9;val++){
                if(isValid(mat, i, j, val)){
                    mat[i][j]=val;
                    if(solve(mat, nextI, nextJ)){
                        return true;
                    }
                    else
                        mat[i][j]=0;
                }
            }
            return false;
        }
    }
    static boolean isValid(int[][] mat, int r, int c, int val){
        for(int i=0;i<9;i++){
            if(mat[i][c]==val || mat[r][i]==val)
            return false;
        }

        int strR = (r/3)*3;

        int strC = (c/3)*3;
        for(int i=strR;i<strR+3;i++){
            for(int j=strC;j<strC+3;j++){
                if(mat[i][j]==val){
                    return false;
                }
            }
        }

        return true;
    }
}