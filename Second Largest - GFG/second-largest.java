//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        int l = arr[0]; // Initialize the largest element
        int sl = -1; // Initialize the second largest element
        
        for (int i = 0; i <=n-1; i++) { // Start from index 1
            if (arr[i] > l) {
                sl = l; // Store the current largest element as the second largest
                l = arr[i]; // Update the largest element
            } else if (arr[i] < l && arr[i] > sl) {
                sl = arr[i]; // Update the second largest element
            }
        }
        
        return sl; // Return the second largest element
    }
}
