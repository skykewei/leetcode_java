package com.leetcode.oj;

public class MaxPathSum_124 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val=x;}
  }
  private int sum = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root){
    if(root==null){
      return 0;
    }
    updateSum(root);
    return sum;
  }
  public void updateSum(TreeNode root){
    if(root==null){
      return;
    }
    int leftMax = singleSum(root.left);
    int rightMax = singleSum(root.right);
    int ts = leftMax + rightMax + root.val;
    if(ts>sum){
      sum = ts;
    }
    updateSum(root.left);
    updateSum(root.right);
  }
  public int singleSum(TreeNode root){
    if(root==null){
      return 0;
    }
    int leftMax = singleSum(root.left);
    int rightMax = singleSum(root.right);
    int ret = root.val + Math.max(leftMax, rightMax);
    return ret;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
