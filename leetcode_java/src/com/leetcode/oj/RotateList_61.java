package com.leetcode.oj;

// 61 https://leetcode.com/problems/rotate-list/
public class RotateList_61 {


  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode rotateRight(ListNode head, int k) {
    int length = 0;
    ListNode p = head;
    while(p!=null){
      length++;
      p = p.next;
    }
    if(length==0){
      return head;
    }
    k %= length;
    if(k==0){
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode cur = dummy;
    while(cur!=null&&k>0){
      cur = cur.next;
      k--;
    }
    while(cur!=null&&cur.next!=null){
      prev = prev.next;
      cur = cur.next;
    }
    ListNode tmpHead = prev.next;
    prev.next = null;
    cur.next=dummy.next;
    return tmpHead;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
