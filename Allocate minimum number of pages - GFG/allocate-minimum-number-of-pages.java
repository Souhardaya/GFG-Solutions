//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to find the minimum number of pages.
    public static int totalStudents(int[] A, int N, int pages) {
        int stu = 1;
        int pagesStudent = 0;
        for (int i = 0; i < N; i++) {
            if (pagesStudent + A[i] <= pages) {
                pagesStudent += A[i];
            } else {
                stu++;
                pagesStudent = A[i];
            }
        }
        return stu;
    }

    public static int findPages(int[] A, int N, int M) {
        if (M>N)
        return-1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < N; i++) {
            low = Math.max(low, A[i]);
            high += A[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int studentCount = totalStudents(A, N, mid);
            if (studentCount > M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
