package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// 94 https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal_94 {


  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  //Moris2
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> retList = new ArrayList<Integer>();
    TreeNode cur = root;
    TreeNode prev = null;
    while(cur!=null){
      if(cur.left==null){
        retList.add(cur.val);
        prev = cur;
        cur =cur.right;
      }else{
        TreeNode node = cur.left;
        while(node.right!=null&&node.right!=cur){
          node = node.right;
        }
        if(node.right==null){
          node.right = cur;
          cur = cur.left;
        }else{
          retList.add(cur.val);
          prev = cur;
          node.right=null;
          cur = cur.right;
        }
      }
    }
    return retList;
  }
  //Moris
  public List<Integer> inorderTraversal_2(TreeNode root) {
    List<Integer> retList = new ArrayList<Integer>();
    TreeNode cur = root;
    TreeNode prev = null;
    while(cur!=null){
      if(cur.left==null){
        retList.add(cur.val);
        prev = cur;
        cur = cur.right;
        continue;
      }
      TreeNode p = cur.left;
      while(p.right!=null&&p.right!=cur){
        p = p.right;
      }
      if(p.right==null){
        p.right = cur;
        cur = cur.left;
      }else{
        retList.add(cur.val);
        p.right=null;
        prev = cur;
        cur = cur.right;
      }
    }
    return retList;
  }
  // stack
  public List<Integer> inorderTraversal_1(TreeNode root) {
    List<Integer> retList = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;
    while (!stack.isEmpty() || p != null) {
      if (p != null) {
        stack.push(p);
        p = p.left;
      } else {
        p = stack.pop();
        retList.add(p.val);
        p = p.right;
      }
    }
    return retList;
  }

  public List<Integer> inorderTraversal_0(TreeNode root) {
    List<Integer> retList = new ArrayList<Integer>();
    recursiveInorder(root, retList);
    return retList;
  }

  private void recursiveInorder(TreeNode root, List<Integer> lt) {
    if (root == null) {
      return;
    }
    recursiveInorder(root.left, lt);
    lt.add(root.val);
    recursiveInorder(root.right, lt);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
