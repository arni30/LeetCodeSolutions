package com.oarnopolin.leetcode.productofarrayexceptself;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        var solution = new Solution();
//        solution.productExceptSelf(new int[]{1, 2, 3, 4});
        solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {

            int product = 1;
            int zeroCount = 0;
            for (int num : nums) {
                if (num != 0) {
                    product *= num;
                } else {
                    zeroCount++;
                }
            }
            if (zeroCount > 1) {
                product = 0;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0 && zeroCount == 0) {
                    nums[i] = product / nums[i];
                } else if (zeroCount > 0 && nums[i] == 0) {
                    nums[i] = product;
                } else {
                    nums[i] = 0;
                }
            }

            return nums;
        }
    }
}
