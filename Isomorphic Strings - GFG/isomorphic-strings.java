//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


//import java.util.HashMap;

class Solution {
    // Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1, String str2) {
        // Check if the lengths of the two strings are different
        if (str1.length() != str2.length()) {
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<>();

        // Iterate through each character in the strings
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i); // Get the character in str1
            char ch2 = str2.charAt(i); // Get the character in str2

            // If ch1 is already mapped to a character
            if (map.containsKey(ch1)) {
                // Check if the mapped character is different from ch2
                if (map.get(ch1) != ch2) {
                    return false; // If different, not isomorphic
                }
            } else {
                // If ch1 is not mapped, check if ch2 is already mapped to a character
                if (map.containsValue(ch2)) {
                    return false; // If mapped, not isomorphic
                }
                // Create the mapping between ch1 and ch2
                map.put(ch1, ch2);
            }
        }

        // If all characters are mapped without any issues, the strings are isomorphic
        return true;
    }
}
