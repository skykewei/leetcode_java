package com.leetcode.oj;
// 260 https://leetcode.com/problems/single-number-iii/
public class SingleNumberIII_260 {

  public int[] singleNumber(int[] nums) {
    if(nums==null||nums.length==0){
      return null;
    }
    int xor = 0;
    for(int i=0;i<nums.length;i++){
      xor ^= nums[i];
    }
    int k=1;
    while((xor&k)==0){
      k<<=1;
    }
    int first = 0;
    int second = 0;
    for(int i=0;i<nums.length;i++){
      if((k&nums[i])!=0){
        first ^= nums[i];
      }else{
        second ^= nums[i];
      }
    }
    int[] ret = {first,second};
    return ret;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
