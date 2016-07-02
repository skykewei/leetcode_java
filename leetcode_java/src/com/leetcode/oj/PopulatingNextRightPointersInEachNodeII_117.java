package com.leetcode.oj;

// 117 https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class PopulatingNextRightPointersInEachNodeII_117 {


  // Definition for binary tree with next pointer.
  public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
      val = x;
    }
  }

  public void connect(TreeLinkNode root) {
    while(root!=null){
      TreeLinkNode next = null;
      TreeLinkNode prev = null;
      for(;root!=null;root=root.next){
         if(next==null){
           next = (root.left==null ?root.right:root.left);
         }
         if(root.left!=null){
           if(prev!=null){
             prev.next = root.left;
           }
           prev = root.left;
         }
         if(root.right!=null){
           if(prev!=null){
             prev.next = root.right;
           }
           prev = root.right;
         }
      }
      root = next;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
