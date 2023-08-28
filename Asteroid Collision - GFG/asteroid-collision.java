//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int a: asteroids){
            while(!st.isEmpty() && a<0 && st.peek()>0){
                int sum=a+st.peek();
                if(sum<0){
                    st.pop();
                }else if(sum>0){
                    a=0;
                }else{
                    st.pop();
                    a=0;
                }
            }
            
            if(a!=0){
                st.push(a);
            }
        }
        int result[]=new int [st.size()];
       int i=result.length-1;
        while(!st.isEmpty()){
            result[i]=st.pop();
            i--;
            
        }
        return result;
    }
}
