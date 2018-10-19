package lintcode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode res = head;
        while (head != null) {
            ListNode temp = head.next;
            while(temp != null && temp.val == head.val) {
                temp = temp.next;
            }
            head.next = temp;
            head = head.next;
        }
        return res;
    }

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
