package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return convert(list, 0, list.size());
    }

    public TreeNode convert(List<Integer> list, int start, int end) {
        if (start == end) {
            return null;
        } else {
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(list.get(mid));
            root.right = convert(list, mid + 1, end);
            root.left = convert(list, start, mid);
            return root;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}