package com.leetcode.oj;
// 33 https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray_33 {

  public int search(int[] nums,int target){
    if(nums==null||nums.length==0){
      return -1;
    }
    int left = 0;
    int right= nums.length-1;
    while(left<=right){
      final int mid = (left+right)>>1;
      if(target==nums[mid]){
        return mid;
      }
      if(nums[mid]>=nums[left]){
        if(target>=nums[left]&&target<=nums[mid]){
          right = mid-1;
        }else {
          left = mid+1;
        }
      }else {
        if(target>nums[mid]&&target<=nums[right]){
          left = mid +1;
        }else {
          right = mid-1;
        }
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
