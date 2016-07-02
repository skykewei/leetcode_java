package com.leetcode.oj;

import java.util.Arrays;

public class NextPermutation_31 {

  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length == 1) {
      return;
    }
    int partitionIndex = nums.length - 2;
    while (partitionIndex>=0&&nums[partitionIndex] >= nums[partitionIndex + 1]) {
      partitionIndex--;
    }
    if (partitionIndex >= 0) {
      int changeIndex = nums.length - 1;
      while (nums[changeIndex] <= nums[partitionIndex]) {
        changeIndex--;
      }
      int tmp = nums[partitionIndex];
      nums[partitionIndex]= nums[changeIndex];
      nums[changeIndex] = tmp;
      int i= partitionIndex+1;
      int j= nums.length-1;
      while(i<j){
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
        j--;
      }
    } else {
      int i = 0;
      int j = nums.length - 1;
      while (i < j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
        j--;
      }
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
