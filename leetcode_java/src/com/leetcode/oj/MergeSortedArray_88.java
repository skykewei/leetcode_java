package com.leetcode.oj;
//88 https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray_88 {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int r3=m+n-1;
    int i1=m-1;
    int i2=n-1;
    while(r3>=0){
      if(i1>=0&&i2>=0){
        if(nums1[i1]>=nums2[i2]){
          nums1[r3]=nums1[i1];
          r3--;
          i1--;
        }else{
          nums1[r3]=nums2[i2];
          r3--;
          i2--;
        }
        continue;
      }
      if(i1>=0){
        nums1[r3]=nums1[i1];
        r3--;
        i1--;
        continue;
      }
      if(i2>=0){
        nums1[r3]=nums2[i2];
        r3--;
        i2--;
        continue;
      }
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
