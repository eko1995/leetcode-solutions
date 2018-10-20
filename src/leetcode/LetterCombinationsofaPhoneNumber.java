package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eko
 * @date 2018/10/20 1:36 PM
 */
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = new LetterCombinationsofaPhoneNumber().letterCombinations(digits);
        System.out.println(res);
    }

    private static List<String> lists = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        lists.add("abc");
        lists.add("def");
        lists.add("ghi");
        lists.add("jkl");
        lists.add("mno");
        lists.add("pqrs");
        lists.add("tuv");
        lists.add("wxyz");
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i< digits.length(); i++) {
            indexs.add(Integer.valueOf(digits.charAt(i) + ""));
        }
        List<StringBuilder> sb = new ArrayList<>();
        sb.add(new StringBuilder());
        List<String> res = createResult(0, indexs, sb);
        return res;
    }

    public List<String> createResult(int i, List<Integer> indexs, List<StringBuilder> builders) {
        if (i == indexs.size()) {
            List<String> res = new ArrayList<>();
            for (StringBuilder sb : builders) {
                res.add(sb.toString());
            }
            return res;
        }
        List<StringBuilder> next = new ArrayList<>();
        for (StringBuilder sb : builders) {
            String s = this.lists.get(indexs.get(i)-2);
            for (int j = 0; j < s.length(); j++) {
                StringBuilder newSb = new StringBuilder(sb);
                newSb.append(s.charAt(j));
                next.add(newSb);
            }
        }
        i++;
        return createResult(i, indexs, next);
    }
}
