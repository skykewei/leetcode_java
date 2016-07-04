package com.leetcode.oj;

// 45 https://leetcode.com/problems/jump-game-ii/
public class JumpGameII_45 {
  public int jump(int[] nums) {
    int left=0;
    int right = 0;
    int step = 0;
    if(nums.length==1){
      return 0;
    }
    while(left<=right){
      step++;
      final int oldRight = right;
      for(int i=left;i<=oldRight;i++){
        int newRight = i+nums[i];
        if(newRight>=nums.length-1){
          return step;
        }
        if(newRight>right){
          right = newRight;
        }
      }
      left = oldRight+1;
    }
    return 0;
  }
}
