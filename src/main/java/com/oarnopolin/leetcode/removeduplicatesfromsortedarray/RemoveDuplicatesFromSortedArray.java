package com.oarnopolin.leetcode.removeduplicatesfromsortedarray;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
*/
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 2}; // Input array
        int[] expectedNums = {1, 2}; // The expected answer with correct length

        int k = solution.removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
            assert nums[i] == expectedNums[i];
        }
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int writeIndex = 1;
            for (int readIndex = 1; readIndex < nums.length; readIndex++) {
                if (nums[readIndex] != nums[readIndex - 1]) {
                    nums[writeIndex] = nums[readIndex];
                    writeIndex++;
                }
            }

            nums = new int[3];
            System.out.println(Arrays.toString(nums));
            return nums.length;
        }
    }
}