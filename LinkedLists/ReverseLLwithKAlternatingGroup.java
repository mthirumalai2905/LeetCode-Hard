class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseAlternateKNodes {
    public static ListNode reverseAlternateK(ListNode head, int k) {
        if (head == null || k <= 0) return head;
        return reverse(head, k, true);
    }

    private static ListNode reverse(ListNode head, int k, boolean reverse) {
        if (head == null) return null;
        
        ListNode prev = null, curr = head, next = null;
        int count = 0;

        if (reverse) {
            while (curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            head.next = reverse(curr, k, !reverse);
            return prev;
        } else {
            ListNode temp = head;
            while (temp != null && count < k - 1) {
                temp = temp.next;
                count++;
            }
            if (temp != null) temp.next = reverse(temp.next, k, !reverse);
            return head;
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("Original List:");
        printList(head);

        head = reverseAlternateK(head, 3);

        System.out.println("Modified List:");
        printList(head);
    }
}
