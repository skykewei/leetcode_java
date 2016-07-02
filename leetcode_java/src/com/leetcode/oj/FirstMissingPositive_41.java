package com.leetcode.oj;
// 41 https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive_41 {

  
  public int firstMissingPositive(int[] nums) {
    if(nums==null||nums.length==0){
      return 1;
    }
    for(int i=0;i<nums.length;i++){
      int tmp = nums[i];
      while(tmp>0&&tmp<=nums.length&&nums[tmp-1]!=tmp){
        int t = nums[tmp-1];
        nums[tmp-1] = tmp;
        tmp = t;
      }
    }
    for(int i=0;i<nums.length;i++){
      if(nums[i]!=i+1){
        return i+1;
      }
    }
    return nums.length+1;
  }
  public static void main(String[] argv){
    int[] a={3,4,-1,1};
    new FirstMissingPositive_41().firstMissingPositive(a);
  }
}
