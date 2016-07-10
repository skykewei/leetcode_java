package com.leetcode.oj;



// 236 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfABinaryTree_236 {

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
    if(root==null){
      return null;
    }
    if(root==p||root==q){
      return root;
    }
    TreeNode L=lowestCommonAncestor(root.left, p, q);
    TreeNode R=lowestCommonAncestor(root.right, p, q);
    if(L!=null&&R!=null){
      return root;
    }
    return L==null?R:L;
  }
  public TreeNode lowestCommonAncestor_0(TreeNode root, TreeNode p, TreeNode q) {
      return dfs(root,p,q);
  }
  private TreeNode dfs(TreeNode root,TreeNode p,TreeNode q){
    if(root==null||p==null||q==null){
      return null;
    }
    if(root==p||root==q){
      return root;
    }
    int count = countPQ(root.left, p, q);
    if(count==1){
      return root;
    }
    if(count==2){
      return lowestCommonAncestor(root.left, p, q);
    }
    return lowestCommonAncestor(root.right, p, q);
  }
  private int countPQ(TreeNode root,TreeNode p,TreeNode q){
    if(root==null){
      return 0;
    }
    int count = countPQ(root.left, p, q)+countPQ(root.right, p, q);
    if(root==q||root==p){
      return 1+count;
    }
    return count;
  }
}
