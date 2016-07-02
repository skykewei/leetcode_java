package com.leetcode.oj;
//109 https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class ConvertSortedArrayToBinarySearchTree_109 {

  public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
  }
  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {val =x;    }
  }
  private ListNode list;
  
  public TreeNode sortedListToBST(ListNode head){
    if(head==null){
      return null;
    }
    int count = 0;
    ListNode p = head;
    while(p!=null){
      p= p.next;
      count++;
    }
    list = head;
    return sortedListToBST(0,count-1);
  }
 
  public TreeNode sortedListToBST(int s,int e){
    if(s>e){
      return null;
    }
    int mid = (s+e)/2;
    TreeNode leftChild = sortedListToBST(s,mid-1);
    TreeNode parent = new TreeNode(list.val);
    parent.left = leftChild;
    list = list.next;
    TreeNode rightChild = sortedListToBST(mid+1,e);
    parent.right = rightChild;
    return parent;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
