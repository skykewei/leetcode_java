package com.leetcode.oj;

// 69 https://leetcode.com/problems/sqrtx/
public class Sqrt_69 {
  public int mySqrt(int x) {
    if (x < 0) {
      return -1;
    }
    if (x == 0 || x == 1) {
      return x;
    }
    int left = 1;
    int right = x >> 1;
    int lastmid = 0;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);

      int r = x / mid;
      if (r > mid) {
        left = mid + 1;
        lastmid = mid;
      } else if (r < mid) {
        right = mid - 1;
      } else {
        return mid;
      }
    }
    return lastmid;
  }
}
