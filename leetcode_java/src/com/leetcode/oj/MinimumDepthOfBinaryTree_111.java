package com.leetcode.oj;

// 111 https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthOfBinaryTree_111 {


  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public int minDepth(TreeNode root) {
    if(root==null){
      return 0;
    }
    int leftMin = minDepth(root.left);
    int rightMin = minDepth(root.right);
    if(leftMin==0){
      return rightMin+1;
    }else{
      if(rightMin==0){
        return leftMin+1;
      }
      return 1+Math.min(leftMin, rightMin);
    }
   
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
