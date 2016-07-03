package com.leetcode.oj;
//75 https://leetcode.com/problems/sort-colors/
public class SortColors_75 {
  public void sortColors(int[] nums) {
   int red=-1;
   int blue=nums.length;
   int i=red+1;
   while(i<blue){
     if(nums[i]==0){
       red++;
       int tmp=nums[red];
       nums[red]=nums[i];
       nums[i]=tmp;
       i = red+1;
     }else if(nums[i]==1){
       i++;
     }else if(nums[i]==2){
       blue--;
       int tmp=nums[blue];
       nums[blue]=nums[i];
       nums[i]=tmp;
     }
   }
  }
}
