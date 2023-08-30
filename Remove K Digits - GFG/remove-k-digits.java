//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        Stack<Character> st = new Stack<>();
        for (char ch : S.toCharArray()) {  // Changed "S.toCharArray" to "S.toCharArray()"
            while (!st.isEmpty() && K > 0 && st.peek() > ch) {
                st.pop();
                K--;  // Changed "k" to "K"
            }
            st.push(ch);
        }
        while (K > 0) {
            st.pop();
            K--;
        }
        StringBuilder str = new StringBuilder();
        for (char ch : st) {
            str.append(ch);
        }
        
        while (str.length() > 0 && str.charAt(0) == '0') {  // Corrected to compare with character '0'
            str.deleteCharAt(0);
        }
        return (str.length() == 0) ? "0" : str.toString();
    }
}
