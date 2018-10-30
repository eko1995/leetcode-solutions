package leetcode;

/**
 * @author eko
 * @date 2018/10/30 10:08 PM
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean res = new ValidPalindrome().isPalindrome(s);
        System.out.println(res);
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        char[] chars = s.toCharArray();
        int lo = 0;
        int hi = chars.length - 1;
        while (lo <= hi) {
            while (lo <= hi && !isAlphanumericCharacter(chars, lo)) {
                lo++;
            }
            while (lo <= hi && !isAlphanumericCharacter(chars, hi)) {
                hi--;
            }

            if (lo > hi) {
                return true;
            }

            if (chars[lo] != chars[hi]) return false;

            lo++;
            hi--;
        }
        return true;
    }

    private boolean isAlphanumericCharacter(char[] chars, int index) {
        if ((chars[index] >= '0' && chars[index] <= '9') || (chars[index] >= 'a' && chars[index] <= 'z')) {
            return true;
        }
        if ((chars[index] >= 'A' && chars[index] <= 'Z')) {
            chars[index] += 32;
            return true;
        }
        return false;
    }
}
