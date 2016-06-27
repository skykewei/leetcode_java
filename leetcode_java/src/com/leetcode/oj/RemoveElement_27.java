package com.leetcode.oj;
//27 https://leetcode.com/problems/remove-element/
public class RemoveElement_27 {

  public int removeElement(int[] nums, int val) {
   if(nums==null||nums.length==0){
     return 0;
   }
   int cnt=0;
   for(int i=0;i<nums.length;i++){
     if(nums[i]!=val){
       nums[cnt]=nums[i];
       cnt++;
     }
   }
   return cnt;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
