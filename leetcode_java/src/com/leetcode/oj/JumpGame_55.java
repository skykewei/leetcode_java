package com.leetcode.oj;

//55 https://leetcode.com/problems/jump-game/
public class JumpGame_55 {
  
  public boolean canJump_0(int[] nums) {
    if(nums==null){
      return false;
    }
    int reach = 0;
    for(int i=0;i<=reach&&reach<nums.length-1;i++){
      reach = Math.max(nums[i]+i,reach);
    }
    return reach>=nums.length-1;
  }
   
  public boolean canJump(int[] nums) {
     int[] f=new int[nums.length];
     f[0] = 0;
     for(int i=1;i<nums.length;i++){
       f[i] = Math.max(f[i-1], nums[i-1])-1;
       if(f[i]<0){
         return false;
       }
     }
     return f[nums.length-1]>=0;
  }
}
