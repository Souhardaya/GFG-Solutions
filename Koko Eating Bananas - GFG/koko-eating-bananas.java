//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int H) {
        int low = 1;
        int high = findMax(piles);
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalH = calculateTotalHours(piles, mid);
            
            if (totalH <= H) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }

    private static int findMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        int n = piles.length;
        
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        
        return maxi;
    }

    private static int calculateTotalHours(int[] piles, int hourly) {
        int totalH = 0;
        int n = piles.length;
        
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(piles[i]) / (double)(hourly));
        }
        
        return totalH;
    }
}
     
