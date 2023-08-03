//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class Driverclass 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			 ArrayList<Integer> ans = new ArrayList<Integer>();
			 ans = new Solution().sortByFreq(arr, size);
			 for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
		    System.out.println();
			n--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public static ArrayList<Integer> sortByFreq(int arr[], int n) {
        ArrayList<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ans.add(arr[i]);
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : arr) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        // Using comparator lambda expression to sort the array
        Collections.sort(ans, (a, b) -> {
            if (hm.get(a).equals(hm.get(b))) {
                return a - b; // If frequencies are the same, sort based on element value in ascending order
            }
            return hm.get(b) - hm.get(a); // Sort based on frequency in descending order
        });

        return ans;
    }
}
