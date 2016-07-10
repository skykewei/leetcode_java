package com.leetcode.oj;

import javax.annotation.PostConstruct;

// 235 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorOfABinarySearchTree_235 {


  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
   
   return dfs(root, p, q);
 
  }
  private TreeNode dfs(TreeNode root,TreeNode p,TreeNode q){
    if(root==null){
      return null;
    }
    if(p.val>q.val){
      return dfs(root, q, p);
    }
    if(root.val>p.val&&root.val<q.val||root.val==p.val||root.val==q.val){
      return root;
    }
    
    if(root.val<p.val){
      return dfs(root.right, p, q);
    }
    
    if(root.val>q.val){
      return dfs(root.left, p, q);
    }
    return null;
  }
}
