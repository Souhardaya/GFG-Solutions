//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        int max=0;
        int current=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                current++;
            }else if(s.charAt(i)==')'){
                current--;
            }
            max=Math.max(max,current);
        }
        return max;
    }
}
        
