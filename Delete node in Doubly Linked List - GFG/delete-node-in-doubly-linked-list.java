//{ Driver Code Starts
//Initial Template for Java
import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
class Delete_Node_From_DLL
{
	Node head;
	Node tail;
	
	void addToTheLast(Node node)
	{
		if(head ==  null)
		{
			head = node;
			tail = node;
		}
		else
		{
			tail.next = node;
			tail.next.prev = tail;
			tail = tail.next;
		}
	}
	
	void printList(Node head)
	{	Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp =  temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			Delete_Node_From_DLL list = new Delete_Node_From_DLL();
			
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			list.addToTheLast(head);
			
			for(int i=1;i<n;i++)
			{
				int a = sc.nextInt();
				list.addToTheLast(new Node(a));
			}
			a1 = sc.nextInt();
			Solution g = new Solution();
			//System.out.println(list.temp.data);
			Node ptr = g.deleteNode(list.head, a1);
			list.printList(ptr);
			t--;
		}
	}
}


                               
// } Driver Code Ends


//User function Template for Java

/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class Solution {
    // function returns the head of the linkedlist
    Node deleteNode(Node head, int x) {
        // Your code here

        // If the list is empty or contains only one node, there is nothing to delete.
        if (head == null || head.next == null) {
            return null;
        }

        // Create a temporary node `temp` and assign it the value of the `head` node.
        Node temp = head;

        // If the node to be deleted is the first node (position 1)
        if (x == 1) {
            head = head.next; // Update the head to the next node.
            head.prev = null; // Update the previous reference of the new head to null.
            return head;
        }

        // Traverse the list to find the node at position x
        int i = 1;
        while (i != x) {
            temp = temp.next;
            i++;
        }

        // Update the `prev` and `next` references to bypass the node to be deleted.
        temp.prev.next = temp.next;

        return head; // Return the head of the modified list.
    }
}


