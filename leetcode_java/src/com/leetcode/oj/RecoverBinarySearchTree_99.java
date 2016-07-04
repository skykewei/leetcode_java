package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBinarySearchTree_99 {

  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public void recoverTree(TreeNode root) {
    ArrayList<TreeNode> lt = new ArrayList<TreeNode>();
    if(root==null){
      return;
    }
    inOrder(root, lt);
    int[] ary = new int[lt.size()];
    int i=0;
    for(TreeNode p:lt){
      ary[i++] = p.val; 
    }
    Arrays.sort(ary);
    i = 0;
    for(TreeNode p:lt){
      p.val = ary[i++];
    }
  }

  private void inOrder(TreeNode root, List<TreeNode> lt) {
    if (root == null) {
      return;
    }
    inOrder(root.left, lt);
    lt.add(root);
    inOrder(root.right, lt);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
