package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author eko
 * @date 2018/10/22 10:32 AM
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new GroupAnagrams().groupAnagrams(strs);
        System.out.println(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                sb.append(chars[j]);
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> str = new ArrayList<>();
                str.add(strs[i]);
                map.put(key, str);
            }
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}
