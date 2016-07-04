package com.leetcode.oj;

import java.util.ArrayDeque;

//116 https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//117 https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class PopulatingNextRightPointersInEachNode_116 {

  
   // Definition for binary tree with next pointer.
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
   
  public void connect(TreeLinkNode root) {
    if(root==null){
      return;
    }
    ArrayDeque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
    queue.add(root);
    TreeLinkNode levelEnd = queue.peekLast();
    while(!queue.isEmpty()){
      TreeLinkNode dummpy = new TreeLinkNode(-1);
      TreeLinkNode prev = dummpy;
      TreeLinkNode tmp = queue.pollFirst();
      while(tmp!=levelEnd){
        prev.next = tmp;
        prev = prev.next;
        if(tmp.left!=null){
          queue.addLast(tmp.left);;
        }
        if(tmp.right!=null){
          queue.addLast(tmp.right);
        }
        tmp = queue.pollFirst();
      }
      prev.next= tmp;
      if(tmp.left!=null){
        queue.addLast(tmp.left);;
      }
      if(tmp.right!=null){
        queue.addLast(tmp.right);
      }
      levelEnd = queue.peekLast();
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
