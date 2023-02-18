package medium;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode current = listNode;
        for (int i = 2; i < 6; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        printList(removeNthFromEnd(listNode, 2));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);

        ListNode left = dummyNode;
        ListNode right = head;

        while (n > 0 && right != null) {
            right = right.next;
            n -= 1;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummyNode.next;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + " ";
        }
    }
}
