//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends




class Solution {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        Map<Integer, Integer> sumMap = new HashMap<>();  // Store cumulative sums and their indices
        int maxLength = 0;
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            sum += A[i];
            
            if (sum == K) {
                maxLength = i + 1;  // Update maxLength if the entire array up to index i forms the subarray
            }
            
            if (sumMap.containsKey(sum - K)) {
                int length = i - sumMap.get(sum - K);
                maxLength = Math.max(maxLength, length);
            }
            
            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, i);
            }
        }
        
        return maxLength;
    }
}

