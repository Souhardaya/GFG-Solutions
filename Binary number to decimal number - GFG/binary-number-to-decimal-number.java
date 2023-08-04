//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.binary_to_decimal(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    public int binary_to_decimal(String str) {
        int i = 0;
        int sum = 0;
        
        // Iterate through the string from right to left
        for (int index = str.length() - 1; index >= 0; index--) {
            char ch = str.charAt(index);
            
            // Convert the character to an integer (0 or 1)
            int digit = ch - '0';
            
            // Perform binary-to-decimal conversion
            sum += digit * Math.pow(2, i);
            i++;
        }
        
        return sum;
    }
}
