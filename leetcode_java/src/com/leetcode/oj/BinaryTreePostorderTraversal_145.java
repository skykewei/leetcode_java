package com.leetcode.oj;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 145 https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal_145 {

  // Definition for a binary tree node.
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  //morris
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> retList = new ArrayList<Integer>();
    TreeNode cur = root;
    TreeNode prev = null;
    while(cur!=null&&prev!=root){
       
    }
    return retList;
  }
  // stack
  public List<Integer> postorderTraversal_1(TreeNode root) {
    List<Integer> retList = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;
    TreeNode prev = null;
    while(!stack.isEmpty()||p!=null){
      if(p!=null){
        stack.push(p);
        p=p.left;
      }else{
        TreeNode tmp = stack.pop();
        if(tmp.right==null||tmp.right==prev){
          prev = tmp;
          retList.add(tmp.val);
        }else{
          stack.push(tmp);
          p = tmp.right;
        }
      }
    }
    return retList;
  }

  public List<Integer> postorderTraversal_0(TreeNode root) {
    List<Integer> retList = new ArrayList<Integer>();
    recursivePostorder(root, retList);
    return retList;
  }

  private void recursivePostorder(TreeNode root, List<Integer> lt) {
    if (root == null) {
      return;
    }
    recursivePostorder(root.left, lt);
    recursivePostorder(root.right, lt);
    lt.add(root.val);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
     TreeNode one = new TreeNode(1);
     TreeNode three = new TreeNode(3);
     three.right = one;
     TreeNode two = new TreeNode(2);
     two.right = three;
     new BinaryTreePostorderTraversal_145().postorderTraversal(two);
  }

}
