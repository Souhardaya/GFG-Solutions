//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node head, int x) {
        Node left = new Node(0); // Dummy node for the left partition (values less than 'x')
        Node right = new Node(0); // Dummy node for the right partition (values greater than or equal to 'x')
        Node middle = new Node(0); // Dummy node for the middle partition (values equal to 'x')

        Node rp = right; // Pointer to the end of the right partition
        Node lp = left; // Pointer to the end of the left partition
        Node mp = middle; // Pointer to the end of the middle partition

        while (head != null) {
            if (head.data < x) {
                lp.next = head;
                lp = lp.next;
            } else if (head.data == x) {
                mp.next = head;
                mp = mp.next;
            } else {
                rp.next = head;
                rp = rp.next;
            }
            head = head.next;
        }

        rp.next = null; // Set the next of the last node of the right partition to null to avoid cycles
        mp.next = right.next; // Connect the end of the middle partition to the start of the right partition
        lp.next = middle.next; // Connect the end of the left partition to the start of the middle partition

        return left.next; // Return the head of the partitioned linked list
    }
}
