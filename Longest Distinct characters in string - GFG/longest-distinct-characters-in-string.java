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
        if (S.length() == 0) {
            return 0;
        }
        int max = 0;
        int l = 0;
        Set<Character> st = new HashSet<>();

        for (int r = 0; r < S.length(); r++) {
            char curr = S.charAt(r);
            if (st.contains(curr)) {
                while (l < r && st.contains(curr)) {
                    char lchar = S.charAt(l);
                    st.remove(lchar); // Changed S.remove(lchar) to st.remove(lchar)
                    l++;
                }
            }
            st.add(curr);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
