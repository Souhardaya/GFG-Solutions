//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class MergeLists
{
    Node head;



  /* Function to print linked list */
   public static void printList(Node head)
    {
        
        while (head!= null)
        {
           System.out.print(head.data+" ");
           head = head.next;
        }  
        System.out.println();
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node head1 = new Node(sc.nextInt());
            Node tail1 = head1;
            for(int i=0; i<n1-1; i++)
            {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }
			Node head2 = new Node(sc.nextInt());
            Node tail2 = head2;
            for(int i=0; i<n2-1; i++)
            {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }
			
			LinkedList obj = new LinkedList();
			Node head = obj.sortedMerge(head1,head2);
			printList(head);
			
			t--;
			
         }
    }
}

// } Driver Code Ends


/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class LinkedList {
    Node merge(Node head1, Node head2) {
        Node sortedtemp = new Node(0);
        Node p = sortedtemp;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                p.next = head1;
                head1 = head1.next; // Added the missing semicolon
            } else {
                p.next = head2;
                head2 = head2.next; // Added the missing semicolon
            }
            p = p.next;
        }

        if (head1 != null) {
            p.next = head1;
        }
        if (head2 != null) {
            p.next = head2;
        }
        return sortedtemp.next;
    }

    // Function to merge two sorted linked lists.
    Node sortedMerge(Node head1, Node head2) {
        Node leftSorted = sortList(head1); // Sort the first linked list
        Node rightSorted = sortList(head2); // Sort the second linked list

        return merge(leftSorted, rightSorted); // Merge the sorted lists
    }

    // Helper method to sort a linked list using Merge Sort (assuming it is already implemented)
    Node sortList(Node head) {
        // Your implementation of Merge Sort goes here
        // It is assumed that the method is already implemented
        return head;
    }
}
