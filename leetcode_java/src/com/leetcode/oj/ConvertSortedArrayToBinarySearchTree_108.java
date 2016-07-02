package com.leetcode.oj;
//108 https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBinarySearchTree_108 {

  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val=x;}
  }
  public TreeNode sortedArrayToBST(int[] nums){
    return sortedArrayToBST(nums, 0, nums.length-1);
  }
  public TreeNode sortedArrayToBST(int[] nums,int f,int t){
    if(nums==null){
      return null;
    }
    if(f>t){
      return null;
    }
    int mid = (f+t)/2;
    TreeNode ret = new TreeNode(nums[mid]);
    ret.left = sortedArrayToBST(nums,f,mid-1);
    ret.right = sortedArrayToBST(nums, mid+1, t);
    return ret;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
