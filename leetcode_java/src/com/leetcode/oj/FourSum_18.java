package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 18 https://leetcode.com/problems/4sum/
public class FourSum_18 {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> retList = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return retList;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length;) {
      for (int j = i + 1; j < nums.length; ) {
       
        int k = j + 1;
        int h = nums.length - 1;
        while (k < h) {
          int tmp = nums[i] + nums[j] + nums[k] + nums[h];
          if (tmp < target) {
            k++;
            while (k < h && nums[k] == nums[k - 1]) {
              k++;
            }
          } else if (tmp > target) {
            h--;
            while (k < h && nums[h] == nums[h + 1]) {
              h--;
            }
          } else {
            ArrayList<Integer> lt = new ArrayList<Integer>();
            lt.add(nums[i]);
            lt.add(nums[j]);
            lt.add(nums[k]);
            lt.add(nums[h]);
            retList.add(lt);
            k++;
            h--;
            while (k < h && nums[k] == nums[k - 1]) {
              k++;
            }
            while (k < h && nums[h] == nums[h + 1]) {
              h--;
            }
          }
        }
        j++;
        while(j<nums.length&&nums[j]==nums[j-1]){
          j++;
        }
      }
      i++;
      while(i<nums.length&&nums[i]==nums[i-1]){
        i++;
      }
    }
    
    return retList;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
