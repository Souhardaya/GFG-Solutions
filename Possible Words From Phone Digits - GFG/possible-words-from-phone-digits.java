//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    void solve(int idx, int N, int[] a, List<String> result, StringBuilder temp, Map<Character, String> mp) {
        if (idx >= N) {
            result.add(temp.toString());
            return;
        }
        
        char ch = (char) (a[idx] + '0');
        String str = mp.get(ch);
        
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            solve(idx + 1, N, a, result, temp, mp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    
    static ArrayList<String> possibleWords(int a[], int N) {
        if (N == 0) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        
        StringBuilder temp = new StringBuilder();
        Solution solution = new Solution();  // Create an instance of the Solution class
        solution.solve(0, N, a, result, temp, mp);  // Call the solve method using the instance
        return (ArrayList<String>) result;
    }
}



