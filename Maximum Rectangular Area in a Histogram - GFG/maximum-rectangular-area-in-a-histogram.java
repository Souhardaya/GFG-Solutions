//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends



class Solution {
    // Function to find the largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) {
        long[] leftsmall = new long[(int) n];
        long[] rightsmall = new long[(int) n];
        Stack<Integer> st = new Stack<>();

        // Calculate the index of the nearest smaller element to the left.
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                leftsmall[i] = 0;
            } else {
                leftsmall[i] = st.peek() + 1;
            }
            st.push(i);
        }

        st.clear();

        // Calculate the index of the nearest smaller element to the right.
        for (int i = (int) n - 1; i >= 0; i--) {
            while (!st.isEmpty() && hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rightsmall[i] = n - 1;
            } else {
                rightsmall[i] = st.peek() - 1;
            }
            st.push(i);
        }

        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, hist[i] * (rightsmall[i] - leftsmall[i] + 1));
        }
        return max;
    }
}




