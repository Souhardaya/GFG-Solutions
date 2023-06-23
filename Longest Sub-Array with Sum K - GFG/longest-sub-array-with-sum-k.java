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
    public static int lenOfLongSubarr(int[] A, int N, int K) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            sum += A[i]; // Calculate the current prefix sum

            if (sum == K) {
                // If the current prefix sum equals K, update the max length if necessary
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = sum - K; // Calculate the remaining sum needed to reach K

            if (preSumMap.containsKey(rem)) {
                // If the remaining sum exists in the map, update the max length if necessary
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!preSumMap.containsKey(sum)) {
                // Store the current prefix sum and its index in the map
                preSumMap.put(sum, i);
            }
            
            if (preSumMap.containsKey(sum - K)) {
                // Handle subarrays with negative or zero sum
                int len = i - preSumMap.get(sum - K);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen; // Return the maximum length of the subarray with sum equal to K
    }
}

