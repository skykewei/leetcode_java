package com.leetcode.oj;

import java.util.function.IntPredicate;

public class MaxSubArray_53 {

  public int maxSubArray(int[] nums){
    if(nums==null||nums.length==0){
      return Integer.MIN_VALUE;
    }
    int max = Integer.MIN_VALUE;
    int curr = max;
    for(int v:nums){
      if(curr<0){
        curr = v;
      }else{
        curr += v;
      }
      if(curr>max){
        max = curr;
      }
    }
    return max;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
