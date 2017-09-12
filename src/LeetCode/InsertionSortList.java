package LeetCode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        ListNode index = head;
        while(index != null) {
            ListNode next = index.next;
            pre = first;
            while(pre.next != null && pre.next.val < index.val) {
                pre = pre.next;
            }
            index.next = pre.next;
            pre.next = index;
            index = next;
        }

        return first.next;
    }
}