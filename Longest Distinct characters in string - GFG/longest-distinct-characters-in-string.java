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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    static int longestSubstrDistinctChars(String S) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = S.length();
        int len = 0;
        
        while (right < n) {
            if (mpp.containsKey(S.charAt(right))) {
                left = Math.max(mpp.get(S.charAt(right)) + 1, left);
            }
            mpp.put(S.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        
        return len;
    }
}
