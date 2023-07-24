//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
	static void printList(Node node, PrintWriter out) 
	{ 
		while (node != null) 
		{ 
			out.print(node.data + " "); 
			node = node.next; 
		} 
		out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans, out); 
            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node divide(int N, Node head) {
        // Initialize two lists to store odd and even nodes separately
        Node oddList = null; // Head of the odd list
        Node evenList = null; // Head of the even list

        // Pointers to traverse the odd and even lists
        Node odd = null;
        Node even = null;

        // Traverse the input linked list
        while (head != null) {
            // Check if the current node's data is even
            if (head.data % 2 == 0) {
                if (even == null) {
                    // If even list is empty, set the head and current pointers to the current even node
                    evenList = head;
                    even = head;
                } else {
                    // Append the current even node to the even list and move the even pointer
                    even.next = head;
                    even = even.next;
                }
            } else {
                // If the current node's data is odd
                if (odd == null) {
                    // If odd list is empty, set the head and current pointers to the current odd node
                    oddList = head;
                    odd = head;
                } else {
                    // Append the current odd node to the odd list and move the odd pointer
                    odd.next = head;
                    odd = odd.next;
                }
            }
            // Move the head pointer to the next node in the original list
            head = head.next;
        }

        // Connect the last node of the even list to the head of the odd list
        if (even != null) {
            even.next = oddList;
        }

        // Set the next of the last node in the odd list to null to terminate the list
        if (odd != null) {
            odd.next = null;
        }

        // Return the head of the even list if it exists, otherwise, return the head of the odd list
        if (evenList != null) {
            return evenList;
        }
        return oddList;
    }
}
