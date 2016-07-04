package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 107 https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTreeLevelOrderTraversalII_107 {

  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  // recursive
  public List<List<Integer>> levelOrderBottom(TreeNode root){
    List<List<Integer>> retList = new ArrayList<List<Integer>>();
    travel(root, 1, retList);
    Collections.reverse(retList);
    return retList;
  }
  private void travel(TreeNode root,int level,List<List<Integer>> ret){
    if(root==null){
      return;
    }
    if(level>ret.size()){
      ret.add(new ArrayList<Integer>());
    }
    ret.get(level-1).add(root.val);
    travel(root.left, level+1, ret);
    travel(root.right, level+1, ret);
   
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
