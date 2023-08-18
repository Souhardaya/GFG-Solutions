//{ Driver Code Starts
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
            System.out.println(ob.isPrime(N));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int isPrime(int N) {
        int c = 0;
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                c++;
                if (i != N / i) { // Only count distinct divisors once
                    c++;
                }
            }
        }
        if (c == 2) {
            return 1; // Prime
        } else {
            return 0; // Not prime
        }
    }
}
