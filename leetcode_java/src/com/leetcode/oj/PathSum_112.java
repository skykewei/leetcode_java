package com.leetcode.oj;

// 112 https://leetcode.com/problems/path-sum/
public class PathSum_112 {


  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public boolean hasPathSum(TreeNode root, int sum) {
    if(root==null){
      return false;
    }
    if(root.left==null&&root.right==null){
      return root.val==sum;
    }
    return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
