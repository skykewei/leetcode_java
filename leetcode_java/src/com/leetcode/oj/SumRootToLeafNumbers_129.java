package com.leetcode.oj;

// 129 https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRootToLeafNumbers_129 {


  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  
  public int sumNumbers(TreeNode root) {
     return  dfs(root, 0);
  }
  private int dfs(TreeNode root, int s){
    if(root==null){
      return 0;
    }
    s = 10*s+root.val;
    if(root.left==null&&root.right==null){
      return s;
    }
    return dfs(root.left, s)+dfs(root.right, s);  
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
