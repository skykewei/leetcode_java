package com.leetcode.oj;
//104 https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree_104 {

  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x;   }
  }
  public int maxDepth(TreeNode root){
    if(root==null){
      return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    int ret = left+1;
    if(right>left){
      ret = right+1;
    }
    return ret;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
