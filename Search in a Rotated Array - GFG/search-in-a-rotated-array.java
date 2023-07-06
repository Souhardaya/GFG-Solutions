//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    int search(int A[], int l, int h, int key) {
        // Base case: If the starting index is greater than the ending index, key is not found
        if (l > h) {
            return -1;
        }

        // Calculate the middle index
        int mid = l + (h - l) / 2;

        // If the middle element is equal to the key, return the middle index
        if (A[mid] == key) {
            return mid;
        }

        // If the left part is sorted
        if (A[l] <= A[mid]) {
            // If the key lies within the sorted left part
            if (key >= A[l] && key <= A[mid]) {
                return search(A, l, mid - 1, key); // Search in the left part
            } else {
                return search(A, mid + 1, h, key); // Search in the right part
            }
        }

        // If the right part is sorted
        // If the key lies within the sorted right part
        if (key >= A[mid] && key <= A[h]) {
            return search(A, mid + 1, h, key); // Search in the right part
        } else {
            return search(A, l, mid - 1, key); // Search in the left part
        }
    }
}