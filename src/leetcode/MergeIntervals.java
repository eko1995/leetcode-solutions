package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author eko
 * @date 2018/10/23 1:39 PM
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 *
 */
public class MergeIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        MergeIntervals solutions = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(solutions.new Interval(1, 3));
        intervals.add(solutions.new Interval(2, 6));
        intervals.add(solutions.new Interval(8, 10));
        intervals.add(solutions.new Interval(15, 18));
        List<Interval> res = solutions.merge(intervals);
        res.forEach(interval -> System.out.println("interval start=" + interval.start + " end=" + interval.end));
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i2 -> i2.start));
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (res.size() == 0) res.add(intervals.get(i));
            else if (res.get(res.size() - 1).end <= intervals.get(i).end) {
                if (res.get(res.size() - 1).end >= intervals.get(i).start) {
                    res.get(res.size() - 1).end = intervals.get(i).end;
                } else {
                    res.add(intervals.get(i));
                }
            }
        }
        return res;
    }
}


/**
 *     Better solution form others(without sorting):
 *
 *     public List<Interval> merge(List<Interval> intervals) {
 *         Interval pre,curr;
 *         List<Interval> ans = new ArrayList<Interval>();
 *         if(intervals.size() == 0)
 *             return ans;
 *         ans.add(intervals.get(0));
 *         for(int j = 0; j < intervals.size(); j++ )
 *         {
 *             pre = intervals.get(j);
 *             for(int i = 0; i < ans.size(); i++)
 *             {
 *                 curr = ans.get(i);
 *                 if(curr.start <= pre.end && curr.end >= pre.start)
 *                 {
 *                     if(pre.start > curr.start)
 *                         pre.start = curr.start;
 *                     if(pre.end < curr.end)
 *                         pre.end = curr.end;
 *                     ans.remove(i);
 *                     i--;
 *                 }
 *             }
 *             ans.add(pre);
 *         }
 *         return ans;
 *     }
 */
