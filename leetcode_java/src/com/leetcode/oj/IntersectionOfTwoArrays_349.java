package com.leetcode.oj;

import java.util.HashSet;
import java.util.Set;

//349 https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays_349 {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<Integer>();
    Set<Integer> result = new HashSet<Integer>();
    for(int i=0;i<nums1.length;i++){
      set.add(nums1[i]);
    }
    for(int i=0;i<nums2.length;i++){
      if(set.contains(nums2[i])){
        result.add(nums2[2]);
      }
    }
    
    Integer[] ret = new Integer[0];
    ret = result.toArray(ret);
    int[] rr = new int[ret.length];
    for(int i=0;i<rr.length;i++){
      rr[i] = ret[i];
    }
    return rr;
  }
}
