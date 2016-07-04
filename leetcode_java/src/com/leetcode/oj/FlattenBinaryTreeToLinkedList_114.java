package com.leetcode.oj;

import java.util.Stack;
// 114 https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

public class FlattenBinaryTreeToLinkedList_114 {

  // Definition for a binary tree node.
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  //recursive
  public void flatten(TreeNode root) {
    if(root==null){
      return;
    }
    flatten(root.left);
    flatten(root.right);
    if(root.left==null){
      return;
    }
    TreeNode p = root.left;
    while(p.right!=null){
      p = p.right;
    }
    p.right = root.right;
    root.right = root.left;
    root.left = null;
  }
  //stack
  public void flatten_0(TreeNode root) {
    if(root==null){
      return;
    }
    TreeNode dummy = new TreeNode(-1);
    TreeNode prev = dummy;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while(!stack.isEmpty()){
      TreeNode p = stack.pop();
      prev.right = p;
      prev.left = null;
      prev = prev.right;
      if(p.right!=null){
        stack.push(p.right);
      }
      if(p.left!=null){
        stack.push(p.left);
      }
    }
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    TreeNode two = new TreeNode(2);
    TreeNode one = new TreeNode(1);
    one.left = two;
    new FlattenBinaryTreeToLinkedList_114().flatten(one);
  }

}
