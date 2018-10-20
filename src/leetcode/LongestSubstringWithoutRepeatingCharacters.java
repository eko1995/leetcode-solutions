package leetcode;

import java.util.HashMap;

/**
 * @author eko
 * @date 2018/10/20 12:56 PM
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        int point = 0;
        HashMap<Character, Integer> res = new HashMap<>();
        for (int i = 0 ; i < s.length(); i++) {
            if (res.containsKey(s.charAt(i)) && res.get(s.charAt(i)) >= point) {
                maxSize = maxSize > i - point ? maxSize : i- point;
                point = res.get(s.charAt(i)) + 1;
            }
            res.put(s.charAt(i), i);
        }

        maxSize = maxSize > s.length() - point ? maxSize : s.length() - point;

        return maxSize;
    }
}
