package leetcode;

/**
 * @author eko
 * @date 2018/10/20 12:32 PM
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode listNode1 = solution.new ListNode(1);
        ListNode listNode2 = solution.new ListNode(2);
        ListNode listNode3 = solution.new ListNode(3);
        ListNode listNode4 = solution.new ListNode(4);
        ListNode listNode5 = solution.new ListNode(5);
        ListNode listNode6 = solution.new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode res = solution.addTwoNumbers(listNode1, listNode4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode index = head;
        int move = 0;
        while(l1 != null || l2 != null) {
            int value = move;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            if (value >= 10) {
                move = 1;
                value = value - 10;
            } else {
                move = 0;
            }
            ListNode newNode = new ListNode(value);
            index.next = newNode;
            index = newNode;
        }

        if (move != 0) {
            index.next = new ListNode(1);
        }

        return head.next;
    }
}
