package com.leetcode.oj;
// 152 https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray_152 {

  public int maxProduct(int[] nums){
    if(nums==null||nums.length==0){
      return Integer.MIN_VALUE;
    }
    int maxEnd = nums[0];
    int minEnd = nums[0];
    int maxSofar = nums[0];
    for(int i=1;i<nums.length;i++){
      int tmin = Math.min(minEnd*nums[i], nums[i]);
       tmin = Math.min(maxEnd*nums[i], tmin);
      int tmax = Math.max(minEnd*nums[i], nums[i]);
      tmax = Math.max(maxEnd*nums[i], tmax);
      minEnd = tmin;
      maxEnd = tmax;
      if(maxSofar < maxEnd){
        maxSofar = maxEnd;
      }
    }
    return maxSofar;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
