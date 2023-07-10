//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG {
    static double medianOfArrays(int n, int m, int a[], int b[]) {
        if (n > m) {
            return medianOfArrays(m, n, b, a);  // Swap the arrays if the first array is longer
        }

        int low = 0;  // Initialize the lower bound of binary search for the first array
        int high = n;  // Initialize the upper bound of binary search for the first array
        int totalElements = (n + m + 1) / 2;  // Calculate the total number of elements for median calculation

        while (low <= high) {
            int partitionA = (low + high) / 2;  // Determine the partition position for the first array
            int partitionB = totalElements - partitionA;  // Determine the partition position for the second array

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : a[partitionA - 1];  // Get the maximum element on the left side of the partition in the first array
            int minRightA = (partitionA == n) ? Integer.MAX_VALUE : a[partitionA];  // Get the minimum element on the right side of the partition in the first array

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : b[partitionB - 1];  // Get the maximum element on the left side of the partition in the second array
            int minRightB = (partitionB == m) ? Integer.MAX_VALUE : b[partitionB];  // Get the minimum element on the right side of the partition in the second array

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // If the partition is correct, calculate the median based on the total number of elements
                if ((n + m) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                // If the partition is too far to the left in the first array, move the partition towards the right
                high = partitionA - 1;
            } else {
                // If the partition is too far to the right in the first array, move the partition towards the left
                low = partitionA + 1;
            }
        }

        return -1.0;  // Return -1 if no median is found
    }
}
