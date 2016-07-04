package com.leetcode.oj;


public class RemoveNthNodeFromEndOfList_19 {

  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head==null){
      return null;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode p = dummy;
    ListNode q = dummy;
    for(int i=0;i<n;i++){
      q = q.next;
    }
    while(q.next!=null){
      q = q.next;
      p = p.next;
    }
    p.next = p.next.next;
    return dummy.next;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
