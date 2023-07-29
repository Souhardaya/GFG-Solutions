//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String S) {
        // Split the input string into words based on whitespace
        String[] words = S.split("\\.");
        
        // Initialize a StringBuilder to build the reversed string
        StringBuilder sb = new StringBuilder();
        
        // Iterate over the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            // Append the current word to the StringBuilder
            sb.append(words[i]);
            
            // Append a space character after each word, except for the last word
            if (i > 0) {
                sb.append(".");
            }
        }
        
        // Convert the StringBuilder contents to a string
        String reversedString = sb.toString();
        
        // Return the reversed string
        return reversedString;
    }
}
