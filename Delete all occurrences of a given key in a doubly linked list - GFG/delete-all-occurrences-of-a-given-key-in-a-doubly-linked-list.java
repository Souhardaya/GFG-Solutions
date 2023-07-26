//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

// a node of the doubly linked list
class Node {
    int data;
    Node next, prev;
}

class GFG {

    /* Function to insert a node at the beginning
        of the Doubly Linked List */
    static Node push(Node head, int new_data) {
        // allocate node
        Node new_node = new Node();

        // put in the data
        new_node.data = new_data;

        /* since we are adding at the beginning,
        prev is always NULL */
        new_node.prev = null;

        // link the old list off the new node
        new_node.next = head;

        // change prev of head node to new node
        if (head != null) head.prev = new_node;

        // move the head to point to the new node
        head = new_node;

        return head;
    }

    /* Function to print nodes in a given doubly
        linked list */
    static void printList(Node temp) {
        if (temp == null) System.out.print(-1);

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Driver code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Node head = null;
            int n = sc.nextInt();
            int inp[] = new int[n];
            for (int i = 0; i < n; i++) inp[i] = sc.nextInt();
            for (int i = n - 1; i >= 0; i--) {
                head = push(head, inp[i]);
            }
            int x = sc.nextInt();
            Solution obj = new Solution();
            head = obj.deleteAllOccurOfX(head, x);
            printList(head);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Initialize a dummy node to simplify handling of the first node
       if (head == null) {
            return null; // If the doubly linked list is empty, return null.
        }
        Node dummy = new Node();
        dummy.next = head;
        head.prev = dummy;

        // Start from the dummy node
        Node current = dummy;
        
        // Traverse the doubly linked list
        while (current != null && current.next != null) {
            if (current.next.data == x) {
                // Remove the node whose data matches x
                Node nodeToDelete = current.next;
                current.next = nodeToDelete.next;
                if (nodeToDelete.next != null) {
                    nodeToDelete.next.prev = current;
                }
                // Delete the nodeToDelete to free memory (optional in some languages with automatic garbage collection)
                nodeToDelete = null;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        // Return the head of the updated doubly linked list
        return dummy.next;
    }
}