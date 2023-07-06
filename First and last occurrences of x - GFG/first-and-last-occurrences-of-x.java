//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


import java.util.ArrayList;

class GFG {
    ArrayList<Long> find(long arr[], int n, int x) {
        int[] nums = new int[n]; // Convert the long array to an integer array
        for (int i = 0; i < n; i++) {
            nums[i] = (int) arr[i];
        }

        int lb = lowerBound(nums, x);  // Get the lower bound index of the target value
        int ub = upperBound(nums, x);  // Get the upper bound index of the target value
        if (lb == nums.length || nums[lb] != x) {
            // If the lower bound index is equal to the array length or the value at the lower bound index is not equal to the target
            // it means the target value is not found in the array
            return new ArrayList<Long>(2) {{
                add((long) -1);
                add((long) -1);
            }};
        }

        return new ArrayList<Long>(2) {{
            add((long) lb);
            add((long) ub);
        }};
    }

    static int lowerBound(int[] nums, int target) {
        int low = 0;  // Starting index of the search range
        int high = nums.length - 1;  // Ending index of the search range
        while (low <= high) {  // Continue the search until the search range is valid
            int mid = (low + high) / 2;  // Calculate the middle index
            if (nums[mid] >= target) {
                // If the value at the middle index is greater than or equal to the target value,
                // move the high pointer to mid - 1 to search in the left half
                high = mid - 1;
            } else {
                // If the value at the middle index is less than the target value,
                // move the low pointer to mid + 1 to search in the right half
                low = mid + 1;
            }
        }
        return low;  // Return the lower bound index (the position where the target value should be inserted)
    }

    static int upperBound(int[] nums, int target) {
        int low = 0;  // Starting index of the search range
        int high = nums.length - 1;  // Ending index of the search range
        while (low <= high) {  // Continue the search until the search range is valid
            int mid = (low + high) / 2;  // Calculate the middle index
            if (nums[mid] > target) {
                // If the value at the middle index is greater than the target value,
                // move the high pointer to mid - 1 to search in the left half
                high = mid - 1;
            } else {
                // If the value at the middle index is less than or equal to the target value,
                // move the low pointer to mid + 1 to search in the right half
                low = mid + 1;
            }
        }
        return high;  // Return the upper bound index (the position after the last occurrence of the target value)
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends