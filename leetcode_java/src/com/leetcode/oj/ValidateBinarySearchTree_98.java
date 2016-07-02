package com.leetcode.oj;

import java.util.ArrayList;

//98 https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree_98 {

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
    ArrayList<Integer> order = new ArrayList<>();
    inorder(root,order);
    int prev = order.get(0);
    order.remove(0);
    for(int v:order){
      if(prev>=v){
        return false;
      }
      prev = v;
    }
    return true;
  }
  private void inorder(TreeNode root,ArrayList<Integer> lt){
    if(root==null){
      return;
    }
    inorder(root.left, lt);
    lt.add(root.val);
    inorder(root.right, lt);
  }
  public boolean isValidBST_0(TreeNode root){
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
