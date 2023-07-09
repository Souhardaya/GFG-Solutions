//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static int leastWeightCapacity(int[] arr, int N, int D) {
        // Find the maximum and minimum possible capacities
        int maxCapacity = 0;
        int sumWeights = 0;
        for (int i = 0; i < N; i++) {
            maxCapacity = Math.max(maxCapacity, arr[i]);
            sumWeights += arr[i];
        }

        // Perform binary search to find the minimum capacity
        int low = maxCapacity;
        int high = sumWeights;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int requiredDays = findRequiredDays(arr, N, mid);
            if (requiredDays > D) {
                low = mid + 1; // Increase the lower bound
            } else {
                high = mid; // Decrease the upper bound
            }
        }
        return low;
    }

    static int findRequiredDays(int[] arr, int N, int capacity) {
        int days = 1;
        int currentLoad = 0;
        for (int i = 0; i < N; i++) {
            if (currentLoad + arr[i] > capacity) {
                days++;
                currentLoad = arr[i];
            } else {
                currentLoad += arr[i];
            }
        }
        return days;
    }
}
