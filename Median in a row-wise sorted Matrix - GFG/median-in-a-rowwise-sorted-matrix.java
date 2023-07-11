//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Method to count the number of elements smaller than or equal to 'mid' in a sorted array 'A'
    private int countSmallerThanMid(int[] A, int mid, int n) {
        int l = 0, h = n - 1;
        while (l <= h) {
            int md = (l + h) >> 1;  // Calculate the middle index using bitwise right shift
            if (A[md] <= mid) {     // If the middle element is less than or equal to 'mid'
                l = md + 1;        // Move the left pointer to the element next to 'md'
            } else {
                h = md - 1;        // Move the right pointer to the element previous to 'md'
            }
        }
        return l;                  // Return the count of elements smaller than or equal to 'mid'
    }

    int median(int matrix[][], int R, int C) {
        int low = 1;                         // Initialize the lower bound of the binary search
        int high = 1000000000;               // Initialize the upper bound of the binary search to a large value
        int n = R;                           // Number of rows in the matrix
        int m = C;                           // Number of columns in the matrix

        while (low <= high) {
            int mid = (low + high) >> 1;       // Calculate the middle value using bitwise right shift
            int cnt = 0;                       // Counter for the number of elements smaller than or equal to 'mid'

            // Iterate over each row in the matrix
            for (int i = 0; i < n; i++) {
                cnt += countSmallerThanMid(matrix[i], mid, C);  // Count the number of elements smaller than or equal to 'mid' in the current row
            }

            // Check if the count is less than or equal to half of the total elements in the matrix
            if (cnt <= (n * m) / 2) {
                low = mid + 1;    // Adjust the lower bound of the binary search
            } else {
                high = mid - 1;   // Adjust the upper bound of the binary search
            }
        }

        return low;           // Return the calculated median
    }
}
