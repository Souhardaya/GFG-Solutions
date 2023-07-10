//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int no_of_subarrays_with_max_sum_as_mid(int[] arr, int N, int mid) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + arr[i] > mid) {
                sum = arr[i];
                count++;
            } else {
                sum += arr[i];
            }
        }

        return count;
    }

    static int splitArray(int[] arr, int N, int K) {
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int n = no_of_subarrays_with_max_sum_as_mid(arr, N, mid);
            if (n > K) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
