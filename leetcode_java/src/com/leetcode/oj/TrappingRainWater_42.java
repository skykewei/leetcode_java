package com.leetcode.oj;
//42 https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater_42 {

  public int trap(int[] height) {
    if(height==null||height.length==0){
      return 0;
    }
    int ret=0;
    int[] left  = new int[height.length];
    int[] right = new int[height.length];
    int cur = height[0];
    for(int i=0;i<height.length;i++){
      if(height[i]>cur){
        cur=height[i];
      }
      left[i]=cur;
    }
    cur = height[height.length-1];
    for(int i=height.length-1;i>=0;i--){
      if(cur<height[i]){
        cur = height[i];
      }
      right[i]=cur;
    }
    for(int i=0;i<height.length;i++){
      ret+=Math.min(left[i], right[i])-height[i];
    }
    return ret;
  }
}
