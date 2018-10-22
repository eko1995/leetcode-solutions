package leetcode;

/**
 * @author eko
 * @date 2018/10/22 10:35 AM
 */
public class PowXn {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        double res = new PowXn().myPow(x, n);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long) n);
        while (absN > 0) {
            if ((absN & 1) == 1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ? 1 / ans : ans;
    }
}
