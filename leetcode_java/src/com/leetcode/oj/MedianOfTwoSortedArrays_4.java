package com.leetcode.oj;

public class MedianOfTwoSortedArrays_4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int total = nums1.length+nums2.length;
    if ((total&1)!=0) {
      return (findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, (total>>1)+1));
    }else {
      return (findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, total>>1)
          +findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, (total>>1)+1))/2.0;
    }
  }
  
  private int findKth(int[] nums1,int f1,int n1, int[] nums2, int f2, int n2 ,int k){
    if(n1>n2){
      return findKth(nums2, f2, n2, nums1, f1, n1, k);
    }
    if(n1==0){
      return nums2[f2+k-1];
    }
    if(k==1){
      return Math.min(nums1[f1], nums2[f2]);
    }
    int ia = Math.min(k>>1, n1);
    int ib = k-ia;
    if(nums1[f1+ia-1]<nums2[f2+ib-1]){
      return findKth(nums1, f1+ia, n1-ia, nums2, f2, n2, k-ia);
    }else if(nums1[f1+ia-1]>nums2[f2+ib-1]){
      return findKth(nums1, f1, n1, nums2, f2+ib, n2-ib, k-ib);
    }else {
      return nums1[f1+ia-1];
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] m = {1,3};
    int[] n = {2};
    double d = new MedianOfTwoSortedArrays_4().findMedianSortedArrays(m, n);
    System.out.println(d);;
  }

}
