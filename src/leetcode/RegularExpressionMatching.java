package leetcode;

/**
 * 10. Regular Expression Matching
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 *
 *
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "a*a"));
    }

    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 1; i < sLen + 1; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < pLen + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                if (j == 1) dp[0][j] = true;
                else
                    dp[0][j] = dp[0][j - 2];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (isTrue(s.charAt(i - 1), p.charAt(j - 2))) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j];
                    }
                } else {
                    dp[i][j] = isTrue(s.charAt(i - 1), p.charAt(j - 1)) && dp[i - 1][j - 1];
                }
            }
        }

        return dp[sLen][pLen];
    }

    public static boolean isTrue(char s, char p) {
        return p == s || p == '.';
    }
}
