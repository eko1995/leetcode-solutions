package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author eko
 * @date 2018/10/30 10:08 PM
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String test = "{[]}";
        System.out.println(new ValidParentheses().isValid(test));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        List<String> stack = new LinkedList<>();
        for (int i = 1; i < s.length(); i++) {

        }
    }
}
