//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
      List<String> list=new ArrayList<String>();
      backtrack(list,"",0,0,n);
      return list;
      }
      public void backtrack(List<String> list,String str,int open,int close,int n){
          if(str.length()==2*n){
          list.add(str);
          return;
          }
          
          if(open<n)
          backtrack(list,str+'(',open+1,close,n);
          if(close<open)
          backtrack(list,str+')',open,close+1,n);
      }
    }
