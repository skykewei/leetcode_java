package com.leetcode.oj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



// 103 https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal_103 {
  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> retList = new ArrayList<List<Integer>>();
    if(root==null){
      return retList;
    }
    ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
    queue.add(root);
    TreeNode levelEnd = queue.peekLast();
    int level=0;
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
      level++;
      if((level&1)==0){
        Collections.reverse(lt);
      }
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
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
