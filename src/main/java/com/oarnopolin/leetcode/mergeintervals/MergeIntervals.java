package com.oarnopolin.leetcode.mergeintervals;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        var res = solution.merge(intervals);
        System.out.println(Arrays.toString(res));
    }
}

class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                result.add(prev);
                prev = interval;
            }
        }
        result.add(prev);
        return result.toArray(new int[result.size()][]);
    }
}
