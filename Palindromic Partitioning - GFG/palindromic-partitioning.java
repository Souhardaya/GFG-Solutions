//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int palindromicPartition(String str) {
        int n = str.length();
        
        // Create a boolean table to store whether a substring is palindrome or not
        boolean[][] isPalindrome = new boolean[n][n];
        
        // Initialize all substrings of length 1 as palindrome
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        
        // Fill the table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                
                if (len == 2) {
                    isPalindrome[start][end] = (str.charAt(start) == str.charAt(end));
                } else {
                    isPalindrome[start][end] = (str.charAt(start) == str.charAt(end)) && isPalindrome[start + 1][end - 1];
                }
            }
        }
        
        // Create a dp array to store the minimum partition count
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0; // No partition needed, as substring from 0 to i is already a palindrome
            } else {
                dp[i] = i; // Initialize with maximum possible value
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        
        return dp[n - 1];
    }}