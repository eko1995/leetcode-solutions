package leetcode;

/**
 * @author eko
 * @date 2018/10/27 2:23 PM
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedList solution = new RemoveDuplicatesfromSortedList();
        ListNode node = solution.new ListNode(1);
        node.next = solution.new ListNode(1);
        node.next.next = solution.new ListNode(2);
        ListNode res = solution.deleteDuplicates(node);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode currentNode = head;
        ListNode index = head.next;
        while (index != null) {
            if (currentNode.val != index.val) {
                currentNode.next = index;
                currentNode = index;
            }
            index = index.next;
        }
        currentNode.next = null;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
