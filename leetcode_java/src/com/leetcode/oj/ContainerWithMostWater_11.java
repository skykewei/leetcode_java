package com.leetcode.oj;


// 11 https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater_11 {
  public int maxArea(int[] height) {
    if (height == null) {
      return 0;
    }
    int N = height.length;
    if (N < 2) {
      return 0;
    }
    int left = 0;
    int right = N-1;
    int max = 0;
    while(left<right){
      max = Math.max(max, (right-left)*Math.min(height[right], height[left]));
      if(height[left]<height[right]){
        left++;
      }else{
        right--;
      }
    }
    return max;
  }
}
