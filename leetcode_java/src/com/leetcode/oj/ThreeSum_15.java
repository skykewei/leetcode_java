package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> retList = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return retList;
    }
    final int target =0 ;
  
    Arrays.sort(nums);
    for(int i=0;i<nums.length;i++){
      if(i>0&&nums[i]==nums[i-1]){
        continue;
      }
      int j=i+1;
      int k=nums.length-1;
      while(j<k){
        if(nums[i]+nums[j]+nums[k]<target){
          j++;
          while(nums[j]==nums[j-1]&&j<k){
            j++;
          }
        }else if(nums[i]+nums[j]+nums[k]>target){
          k--;
          while(nums[k]==nums[k+1]&&j<k){
            k--;
          }
        }else{
          ArrayList<Integer> lt = new ArrayList<Integer>();
          lt.add(nums[i]);
          lt.add(nums[j]);
          lt.add(nums[k]);
          retList.add(lt);
          j++;
          k--;
          while(nums[j]==nums[j-1]&&j<k){
            j++;
          }
          while(nums[k]==nums[k+1]&&j<k){
            k--;
          }
        }
      }
    }
    return retList;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
