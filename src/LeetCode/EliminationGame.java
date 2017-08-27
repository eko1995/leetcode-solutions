package LeetCode;

public class EliminationGame {
    public static int lastRemaining(int n) {
        int remain = n;
        int head = 1;
        int step = 1;
        boolean left = true;
        while (remain > 1) {
            if (left || remain % 2 == 1) {
                head += step;
            }
            step = step * 2;
            remain = remain / 2;
            left = !left;
        }
        return head;
    }
}