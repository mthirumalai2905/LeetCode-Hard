class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = this; // make it circular by default
    }
}

class Solution {
    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);

        // Case 1: List is empty
        if (head == null) return newNode;

        Node curr = head;

        // Case 2: Insert before head (new min or max)
        if (data <= head.data) {
            // find the last node
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.next = head;
            return newNode; // new head
        }

        // Case 3: Insert in middle or end
        while (curr.next != head && curr.next.data < data) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        return head; // head remains unchanged
    }
}
