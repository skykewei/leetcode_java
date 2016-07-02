package com.leetcode.oj;
// 106 https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {


  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  // no check for parameter
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return build(inorder, 0, inorder.length, postorder, 0, postorder.length-1);
  }
  private TreeNode build(int[]inorder,int ii,int ij,int[]postorder,int pi,int pj){
    if(ii>ij){
      return null;
    }
    if(pi>pj){
      return null;
    }
    int rootVal = postorder[pj];
    TreeNode root = new TreeNode(rootVal);
    int index = ii;
    while(index<=ij&&inorder[index]!=rootVal){
      index++;
    }
    if(index>ij){
      return null;
    }
    TreeNode lefft = build(inorder, ii, index-1, postorder, pi, pi+index-ii-1);
    TreeNode right = build(inorder, index+1, ij, postorder, pi+index-ii, pj-1);
    root.left = lefft;
    root.right=right;
    return root;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
