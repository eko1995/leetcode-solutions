package leetcode;

/**
 * @author eko
 * @date 2018/10/20 1:16 PM
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String res = new ZigZagConversion().convert(s, numRows);
        System.out.println(res);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        StringBuilder result = new StringBuilder();
        int index = 0;
        boolean isDesc = true;
        for (int i = 0; i < s.length(); i++) {
            if (res[index] == null) {
                res[index] = new StringBuilder();
            }
            res[index].append(s.charAt(i));
            if (isDesc) {
                if (index == numRows - 1) {
                    isDesc = false;
                    index--;
                } else {
                    index++;
                }
            } else {
                if (index == 0) {
                    isDesc = true;
                    index++;
                } else {
                    index--;
                }
            }
        }
        for (int i = 0; i < numRows; i++) {
            if (res[i] != null) {
                result.append(res[i]);
            }
        }
        return result.toString();
    }
}
