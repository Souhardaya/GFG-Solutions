//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution {
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
        Stack<Integer> st = new Stack<>();
        
        // Push all people onto the stack.
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            
            if (M[a][b] == 1) {
                // If a knows b, then 'a' cannot be the celebrity.
                st.push(b);
            } else {
                // If a doesn't know b, then 'b' cannot be the celebrity.
                st.push(a);
            }
        }
        
        int candidate = st.peek(); // Possible celebrity candidate.
        
        // Verify if the candidate is a celebrity.
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[i][candidate] == 0 || M[candidate][i] == 1) {
                    return -1; // 'i' doesn't know 'candidate' or 'candidate' knows 'i'.
                }
            }
        }
        
        return candidate;
    }
}
