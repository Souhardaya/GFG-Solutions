//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
    static void printList(Node node) 
    { 
        while (node != null) 
        { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
        System.out.println(); 
    }
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            Node head = null;
            for(int i=0; i<n; i++)
            {
                int value = sc.nextInt();
                int indicator = sc.nextInt();

                Solution ob = new Solution();
                if(indicator == 0)
                    head = ob.insertAtBeginning(head, value);
                else
                    head = ob.insertAtEnd(head, value);
            }
            printList(head); 
            t--;
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
class Solution {
    // Function to insert a node at the beginning of the linked list.
    public Node insertAtBeginning(Node head, int data) {
        Node newBlock = new Node(data);
        newBlock.next = head;
        head = newBlock;
        return head;
    }

    // Function to insert a node at the end of the linked list.
    public Node insertAtEnd(Node head, int data) {
        Node newBlock = new Node(data);
        newBlock.next = null;

        if (head == null) {
            // If the linked list is empty, the new node becomes the head and tail.
            head = newBlock;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newBlock;
        }

        return head;
    }
}
