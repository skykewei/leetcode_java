package com.leetcode.oj;

import java.util.Arrays;

// 105 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {


  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  // no array check
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
  }

  private TreeNode build(int[]preorder,int pi,int pj,int[] inorder,int ii,int ij){
    if(pi>pj){
      return null;
    }
    int rootVal = preorder[pi];
    TreeNode root = new TreeNode(rootVal);
    int index = ii;
    while(index<=ij&&inorder[index]!=rootVal){
      index++;
    }
    
    TreeNode left = build(preorder, pi+1, pi+index-ii, inorder, ii, index-1);
    TreeNode right = build(preorder, pi+index-ii+1, pj, inorder, index+1, ij);
    root.left = left;
    root.right = right;
    return root;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
