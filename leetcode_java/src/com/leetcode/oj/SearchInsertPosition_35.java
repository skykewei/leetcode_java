package com.leetcode.oj;
// 35 https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition_35 {

  public int searchInsert(int[] nums, int target) {
    if(nums==null){
      return -1;
    }
    int left=0;
    int right = nums.length-1;
    while(left<=right){
      int mid = (left+right)>>1;
      if(nums[mid]==target){
        return mid;
      }
      if(target>nums[mid]){
        left=mid+1;
      }else {
        right=mid-1;
      }
    }
    return left;
  }
}
