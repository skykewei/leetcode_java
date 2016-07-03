package com.leetcode.oj;

// 34 https://leetcode.com/problems/search-for-a-range/
public class SearchForARange_34 {

  public int[] searchRange(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      if (nums[left] == target && nums[right] == target) {
        return new int[] {left, right};
      }
      int mid = (left + right) >> 1;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        int tmp = mid;
        while (left < tmp) {
          int m = (left + tmp) >> 1;
          if (nums[m] < target) {
            left = m + 1;
          } else if (nums[m] == target) {
            tmp = m;
          }
        }
        tmp = mid;
        while (tmp < right) {
          int m = (tmp + right+1) >> 1;
          if (nums[m] > target) {
            right = m - 1;
          } else if (nums[m] == target) {
            tmp = m;
          }
        }

      }
    }
    if (left == right && nums[left] == target) {
      return new int[] {left, right};
    } else {
      return new int[] {-1, -1};
    }
  }
}
