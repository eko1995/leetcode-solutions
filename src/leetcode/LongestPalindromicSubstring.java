package leetcode;

/**
 * @author eko
 * @date 2018/10/20 1:03 PM
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String res = new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        String res = "";
        int preStart = 0;
        int preEnd = 0;
        for (int i= 0; i< s.length(); i++) {
            for (int j= i; j < s.length(); j++) {
                if (j-i+1 > res.length() && isPalindrome(s, i, j, preStart, preEnd)) {
                    preStart = i;
                    preEnd = j - 1;
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int start, int end, int preStart, int preEnd) {
        while (start < end) {
            if (start == preStart && end == preEnd) {
                return true;
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
