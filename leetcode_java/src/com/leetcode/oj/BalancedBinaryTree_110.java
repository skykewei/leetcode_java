package com.leetcode.oj;
//110 https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree_110 {

  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x;   }
  }
  public int height(TreeNode root){
    if(root==null){
      return 0;
    }
    int left = height(root.left);
    int right = height(root.right);
    return Math.max(left, right)+1;
  }
  class Res{
    int height;
    boolean isBalanced;
  }
  Res cal(TreeNode root){
    Res ret = new Res();
    if(root==null){
      ret.height = 0;
      ret.isBalanced = true;
      return ret;
    }
    Res left = cal(root.left);
    Res right= cal(root.right);
    ret.height = Math.max(left.height, right.height)+1;
    if(left.isBalanced==false||right.isBalanced==false){
      ret.isBalanced = false;
      return ret;
    }
    if(Math.abs(left.height-right.height)>1){
      
      ret.isBalanced = false;
      return ret;
    }
    ret.isBalanced = true;
    return ret;
  }
  public boolean isBalanced(TreeNode root){
    if(root==null){
      return true;
    }
    Res cl = cal(root);
    return cl.isBalanced;
  }
  public boolean isBalanced2(TreeNode root){
    if(root==null){
      return true;
    }
    boolean leftValid = isBalanced(root.left);
    boolean rightValid = isBalanced(root.right);
    int leftHeight = height(root.left);
    int rightHeight=height(root.right);
    return Math.abs(leftHeight-rightHeight)<=1&&leftValid&&rightValid;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
