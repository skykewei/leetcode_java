package com.leetcode.oj;


// 100 https://leetcode.com/problems/same-tree/
public class SameTree_100 {

  // Definition for a binary tree node.
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  public boolean isSameTree(TreeNode p, TreeNode q) {
     if(p==null||q==null){
       return p==q;
     }
     if(p.val!=q.val){
       return false;
     }
     return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
