package com.oarnopolin.leetcode.insertinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        var res = solution.insert(intervals, newInterval);
        System.out.println(Arrays.toString(res));
    }
}

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length + 1][]; // Create a new array with an extra row

        // Copy existing rows
        System.arraycopy(intervals, 0, newArr, 0, intervals.length);

        // Add new row
        newArr[intervals.length] = newInterval;
        intervals = newArr;

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
