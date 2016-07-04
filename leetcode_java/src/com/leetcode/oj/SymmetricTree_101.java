package com.leetcode.oj;

//101 https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree_101 {

  // Definition for a binary tree node.
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  public boolean isSymmetric(TreeNode root) {
    if(root==null){
      return true;
    }
    return sym(root.left, root.right);
  }
  private boolean sym(TreeNode p,TreeNode q){
    if(p==null||q==null){
      return p==q;
    }
    if(p.val!=q.val){
      return false;
    }
    return sym(p.left, q.right)&&sym(p.right, q.left);
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
