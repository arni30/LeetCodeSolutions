package com.oarnopolin.leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
 */

public class TwoSum {


    public static void main(String[] args) {
        Solution solution = new Solution();
        var nums1 = new int[]{3,2,4};
        var target = 6;
        var result = solution.twoSum(nums1, target);
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }


}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> differences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer elem = differences.get(diff);
            if (elem != null)
                return new int[]{elem, i};
            else
                differences.put(nums[i], i);
        }
        return null;
    }
}
