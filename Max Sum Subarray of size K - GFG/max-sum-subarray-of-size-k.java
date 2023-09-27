//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        int i = 0;
        int j = 0;
        long maxLen = 0; // Changed to long to store the maximum sum
        long currentSum = 0;

        while (j < N) {
            currentSum += Arr.get(j);

            if (j - i + 1 > K) {
                currentSum -= Arr.get(i);
                i++;
            }

            if (j - i + 1 == K) {
                maxLen = Math.max(maxLen, currentSum);
            }

            j++;
        }
        return maxLen;
    }}