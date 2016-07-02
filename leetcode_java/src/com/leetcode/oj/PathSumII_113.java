package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 113 https://leetcode.com/problems/path-sum-ii/
public class PathSumII_113 {
  
   // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
  
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> retList = new ArrayList<>();
    if(root==null){
      return retList;
    }
    List<Integer> lt = new ArrayList<>();
    path(root,sum,lt,retList);
    return retList;
  }
  // root must not null
  public void path(TreeNode root,int sum,List<Integer> lt,List<List<Integer>> retList){
    if(root==null){
      return;
    }
    // Tree leaf
    if(root.left==null&&root.right==null){
      if(sum==root.val){
        lt.add(root.val);
        retList.add(new ArrayList<>(lt));
        lt.remove(lt.size()-1);
      }
      return;
    }
    
    if(root.left!=null){
      lt.add(root.val);
      path(root.left, sum-root.val, lt, retList);
      lt.remove(lt.size()-1);
    }
    if(root.right!=null){
      lt.add(root.val);
      path(root.right, sum-root.val, lt, retList);
      lt.remove(lt.size()-1);
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
