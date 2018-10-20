package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eko
 * @date 2018/10/20 1:42 PM
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndofList solution = new RemoveNthNodeFromEndofList();
        ListNode node = solution.new ListNode(1);
        node.next = solution.new ListNode(2);
        node.next.next = solution.new ListNode(3);
        node.next.next.next = solution.new ListNode(4);
        node.next.next.next.next = solution.new ListNode(5);
        ListNode res = solution.removeNthFromEnd(node, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> bucket = new ArrayList<>();
        while (head != null) {
            bucket.add(head);
            head = head.next;
        }
        if (n == bucket.size()) {
            return bucket.get(0).next;
        }
        if (n == 1) {
            if (bucket.size() > 1)
                bucket.get(bucket.size() - 2).next = null;
            else
                return null;
        } else {
            bucket.get(bucket.size() - n - 1).next = bucket.get(bucket.size() - n + 1);
        }
        return bucket.get(0);
    }
}
