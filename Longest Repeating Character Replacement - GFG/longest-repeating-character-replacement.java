//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            s = s.toUpperCase();
            int ans = obj.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) { in = is; }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int characterReplacement(String S, int K) {
        int n=S.length();
        int l=0;
        int maxr=0;
        int nr=0;
       int maxlength=0;
        Map<Character,Integer>mp=new HashMap<>();
        for(int r=0;r<n;r++){
            char curr=S.charAt(r);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
            maxr=Math.max(maxr,mp.get(curr));
             nr=(r-l+1)-maxr;
            if(nr>K){
                char lr=S.charAt(l);
                mp.put(lr,mp.get(lr)-1);
                l++;
            }
            maxlength=Math.max(maxlength,r-l+1);
            
        }
        return maxlength;
    }
}
