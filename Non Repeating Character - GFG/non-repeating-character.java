//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S) {
        HashMap<Character, Integer> map = new HashMap<>(); // Corrected HashMap declaration
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i)) && map.get(S.charAt(i)) == 1) { // Corrected conditions
                return S.charAt(i); // Return the character, not char(i)
            }
        }
        return '$'; // Return a placeholder value if no non-repeating character is found
    }
}
   

