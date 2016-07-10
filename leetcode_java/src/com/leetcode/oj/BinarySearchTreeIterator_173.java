package com.leetcode.oj;

import java.util.Stack;
//173 https://leetcode.com/problems/binary-search-tree-iterator/
public class BinarySearchTreeIterator_173 {

  // Definition for binary tree
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public class BSTIterator {

    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
      stack = new Stack<>();
      TreeNode p = root;
      while(p!=null){
        stack.push(p);
        p=p.left;
      }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
      if(!hasNext()){
        throw new IllegalStateException("no more elements");
      }
      TreeNode pNode = stack.pop();
      TreeNode p = pNode.right;
      while(p!=null){
        stack.add(p);
        p=p.left;
      }
      return pNode.val;
    }
  }

  /**
   * Your BSTIterator will be called like this: BSTIterator i = new BSTIterator(root); while
   * (i.hasNext()) v[f()] = i.next();
   */
}
