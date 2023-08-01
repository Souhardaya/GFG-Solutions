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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int isHappy(int N) {
        // Create a set to store the previously encountered numbers
        Set<Integer> usedIntegers = new HashSet<>();
        
        // Loop until a return statement is encountered (infinite loop)
        while (true) {
            // Initialize a variable to store the sum of squares of digits
            int sum = 0;
            
            // Calculate the sum of squares of digits by extracting digits and adding their squares to 'sum'
            while (N != 0) {
                int digit = N % 10; // Get the rightmost digit
                sum += digit * digit; // Square the digit and add it to 'sum'
                N = N / 10; // Remove the rightmost digit from 'N'
            }
            
            // Check if the sum is equal to 1, indicating a happy number
            if (sum == 1) {
                return 1;
            }
            
            // Update 'N' to the calculated sum for the next iteration
            N = sum;
            
            // Check if the current sum has been encountered before (cycle detected)
            // If so, return 0 as it will lead to an infinite loop and not result in 1
            if (usedIntegers.contains(N)) {
                return 0;
            }
            
            // Add the current sum to the set of used integers to track it
            usedIntegers.add(N);
        }
    }
}