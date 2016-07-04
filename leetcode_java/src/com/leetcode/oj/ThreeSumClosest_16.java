package com.leetcode.oj;

import java.util.Arrays;

// 16 https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest_16 {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int ret= nums[0]+nums[1]+nums[2];
    for(int i=0;i<nums.length;i++){
      int j=i+1;
      int k=nums.length-1;
      while(j<k){
         int tmp = nums[i]+nums[j]+nums[k];
         if(Math.abs(target-ret)>Math.abs(target-tmp)){
           ret = tmp;
         }
         if(tmp<target){
           j++;
         }else if(tmp>target){
           k--;
         }else{
           return target;
         }
      }
    }
    return ret;
  }
}
