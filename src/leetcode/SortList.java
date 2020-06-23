package leetcode;

/**
 * 148. Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 *
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode();
        h.next = head;
        quikSort(h, null);
        return h.next;
    }

    public void quikSort(ListNode head, ListNode tail)
    {
        if (head.next == tail || head.next.next == tail)
        {
            return;
        }
        ListNode compare = head.next;
        ListNode idx = head.next;
        while(idx.next != tail)
        {
            ListNode cur = idx.next;
            if (cur.val < compare.val)
            {
                idx.next = idx.next.next;
                cur.next = head.next;
                head.next = cur;
                continue;
            }
            idx = idx.next;
        }
        quikSort(head, compare);
        quikSort(compare, tail);
    }

    public class ListNode {
        public int val;
        public ListNode next;
    }
}
