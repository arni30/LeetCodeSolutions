package com.oarnopolin.leetcode.summaryranges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        var solution = new Solution();
        solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
    }

    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            int end = 0;
            int start = 0;
            List<String> result = new ArrayList<>();
            while (end < nums.length) {
                if (end + 1 >= nums.length || nums[end + 1] != nums[end] + 1) {
                    if (start == end) {
                        result.add(String.valueOf(nums[start]));
                    } else {
                        result.add(nums[start] + "->" + nums[end]);
                    }
                    start = end + 1;
                }
                end++;
            }
            return result;
        }
    }
}
