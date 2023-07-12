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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    String longestCommonPrefix(String arr[], int n) {
        // If the array is empty, return -1
        if (n == 0) {
            return "-1";
        }
        
        // Initialize the prefix as the first string in the array
        String prefix = arr[0];
        
        // Iterate through the remaining strings in the array
        for (int i = 1; i < n; i++) {
            // While the prefix is not a prefix of the current string, keep removing the last character of the prefix
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If the prefix becomes empty, there is no common prefix, so return -1
                if (prefix.isEmpty()) {
                    return "-1";
                }
            }
        }
        
        // Return the longest common prefix
        return prefix;
    }
}
