package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 144 https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal_144 {


  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> retList = new ArrayList<Integer>();
    if(root==null){
      return retList;
    }
    TreeNode prev = null;
    TreeNode cur = root;
    while(cur!=null){
      if(cur.left==null){
        retList.add(cur.val);
        prev = cur;
        cur = cur.right;
      }else{
        TreeNode node = cur.left;
        while(node.right!=null&&node.right!=cur){
          node=node.right;
        }
        if(node.right==null){
          retList.add(cur.val);
          node.right = cur;
          prev = cur;
          cur=cur.left;
        }else{
          node.right = null;
          cur= cur.right;
        }
      }
    }
    return retList;
  }
  // stack
  public List<Integer> preorderTraversal_1(TreeNode root) {
    List<Integer> retList = new ArrayList<Integer>();
    if (root == null) {
      return retList;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode tmp = stack.pop();
      retList.add(tmp.val);

      if (tmp.right != null) {
        stack.push(tmp.right);
      }
      if (tmp.left != null) {
        stack.push(tmp.left);
      }
    }
    return retList;
  }

  public List<Integer> preorderTraversal_0(TreeNode root) {
    List<Integer> retList = new ArrayList<Integer>();
    recursivePreorder(root, retList);
    return retList;
  }

  private void recursivePreorder(TreeNode root, List<Integer> lt) {
    if (root == null) {
      return;
    }
    lt.add(root.val);
    recursivePreorder(root.left, lt);
    recursivePreorder(root.right, lt);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
