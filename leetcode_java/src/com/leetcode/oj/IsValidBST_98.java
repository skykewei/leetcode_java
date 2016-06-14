package com.leetcode.oj;

public class IsValidBST_98 {

  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val=x;}
  }
  public boolean isValidBST(TreeNode root){
    if(root==null){
      return true;
    }
    TreeNode leftMax = root.left;
    while(leftMax!=null&&leftMax.right!=null){
      leftMax = leftMax.right;
    }
    if(leftMax!=null&&!(leftMax.val<root.val)){
      return false;
    }
    TreeNode rightMin = root.right;
    while(rightMin!=null&&rightMin.left!=null){
      rightMin = rightMin.left;
    }
    if(rightMin!=null&&!(rightMin.val>root.val)){
      return false;
    }
    return isValidBST(root.left)&&isValidBST(root.right);
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
