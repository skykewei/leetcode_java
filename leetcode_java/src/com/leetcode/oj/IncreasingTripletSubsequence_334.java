package com.leetcode.oj;
//334 https://leetcode.com/problems/increasing-triplet-subsequence/
public class IncreasingTripletSubsequence_334 {
  public boolean increasingTriplet_0(int[] nums) {
    if(nums==null||nums.length<3){
      return false;
    }
    int[] f=new int[nums.length];
    for(int i=0;i<nums.length;i++){
      f[i]=1;
      for(int j=i-1;j>=0;j--){
        if(nums[i]>nums[j]){
          f[i] = Math.max(f[i], f[j]+1);
        }
      }
      if(f[i]>=3){
        return true;
      }
    }
    return false;
  }
  public boolean increasingTriplet(int[] nums) {
    if(nums==null||nums.length<3){
      return false;
    }
    int min1=Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
    for(int i=0;i<nums.length;i++){
       if(nums[i]<=min1){
         min1 = nums[i];
       }else if(nums[i]<=min2){
         min2 = nums[i];
       }else {
         return true;
       }
    }
    return false;
  }
}
