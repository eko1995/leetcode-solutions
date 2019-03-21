package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eko
 * @date 2018/10/23 1:30 PM
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 */
public class IntegerToRoman {
    public static Map<Integer, String> integerRomanMap = new HashMap<>();
    static {
        integerRomanMap.put(0, "");
        for (int i = 3; i >= 0; i --) {
            String one = "";
            String five = "";
            int mutiple = 1;
            if (i == 0) {
                one = "I";
                five = "V";
            }
            if (i == 1) {
                one = "X";
                five = "L";
                mutiple = 10;
            }
            if (i == 2) {
                one = "C";
                five = "D";
                mutiple = 100;
            }
            if (i == 3) {
                one = "M";
                mutiple = 1000;
            }

            for (int j = 1; j < 10 ; j++) {
                Integer number = j * mutiple;
                String roman = "";
                if (j <= 3) {
                    for (int k = 0; k < j; k++) {
                        roman += one;
                    }
                    integerRomanMap.put(number, roman);
                }
                if (j == 4) {
                    roman = one + five;
                    integerRomanMap.put(number, roman);
                }

                if (j == 5) {
                    roman = five;
                    integerRomanMap.put(number, roman);
                }

                if (j > 5 && j < 9) {
                    for (int k = 0; k < j - 5; k++) {
                        roman += one;
                    }
                    roman = five + roman;
                    integerRomanMap.put(number, roman);
                }

                if (j == 9) {
                    roman = one + integerRomanMap.get(mutiple * 10);
                    integerRomanMap.put(number, roman);
                }
            }
        }
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println(new IntegerToRoman().intToRoman(num));
    }

    public String intToRoman(int num) {
        int multiple = 1;
        String res = "";
        while (num > 0) {
            int number = num % 10;
            res = integerRomanMap.get(number * multiple) + res;
            num = num / 10;
            multiple = multiple * 10;
        }
        return res;
    }
}
