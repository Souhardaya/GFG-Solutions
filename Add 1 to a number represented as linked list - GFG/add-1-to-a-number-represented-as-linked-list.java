//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


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

class Solution
{
    public Node reverse(Node head) {
        Node next = null;
        Node prev = null;
        Node cur = head;
        
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    public Node addOne(Node head) {
        // Reverse the linked list first
        head = reverse(head);
        
        int carry = 1;
        Node cur = head;
        
        while (cur != null) {
            int sum = cur.data + carry;
            cur.data = sum % 10;
            carry = sum / 10;
            
            if (carry == 0) {
                break;
            }
            
            if (cur.next == null) {
                cur.next = new Node(carry);
                break;
            }
            
            cur = cur.next;
        }
        
        return reverse(head);
    }
}

