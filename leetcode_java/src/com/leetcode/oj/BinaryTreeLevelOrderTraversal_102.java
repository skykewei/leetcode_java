package com.leetcode.oj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
// 102 https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal_102 {


  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
 
  // queue
  public List<List<Integer>> levelOrder_0(TreeNode root) {
    List<List<Integer>> retList = new ArrayList<List<Integer>>();
    if(root==null){
      return retList;
    }
    ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
    queue.add(root);
    TreeNode levelEnd = queue.peekLast();
    while(!queue.isEmpty()){
      ArrayList<Integer> lt = new ArrayList<Integer>();
      TreeNode tmp = queue.pollFirst();
      while(tmp!=levelEnd){
        lt.add(tmp.val);
        if(tmp.left!=null){
          queue.addLast(tmp.left);;
        }
        if(tmp.right!=null){
          queue.addLast(tmp.right);
        }
        tmp = queue.pollFirst();
      }
      lt.add(tmp.val);
      retList.add(lt);
      if(tmp.left!=null){
        queue.addLast(tmp.left);;
      }
      if(tmp.right!=null){
        queue.addLast(tmp.right);
      }
      levelEnd = queue.peekLast();
    }
    return retList;
  }

  // recursive
  public List<List<Integer>> levelOrder(TreeNode root){
    List<List<Integer>> retList = new ArrayList<List<Integer>>();
    travel(root, 1, retList);
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
