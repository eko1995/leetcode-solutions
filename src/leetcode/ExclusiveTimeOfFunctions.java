package leetcode;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0) {
            return null;
        }
        Stack<String[]> stack = new Stack<>();
        int[] res = new int[n];

        logs.stream().forEach(log -> {
            String[] strs = log.split(":");
            if (strs[1].equals("start")) {
                stack.push(strs);
            } else {
                String[] popStrs = stack.pop();
                res[Integer.valueOf(popStrs[0])] += Integer.valueOf(strs[2]) - Integer.valueOf(popStrs[2]) + 1;
                if(!stack.empty()) {
                    String[] peekStrs = stack.peek();
                    res[Integer.valueOf(peekStrs[0])] -= Integer.valueOf(strs[2]) - Integer.valueOf(popStrs[2]) + 1;
                }
            }
        });

        return res;
    }
}
