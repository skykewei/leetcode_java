package com.leetcode.oj;

public class LinkedListCycleII_142 {

  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
  public ListNode detectCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while(fast!=null&&fast.next!=null){
        slow = slow.next;
        fast=fast.next.next;
        if(slow==fast){
          ListNode p = head;
          while(p!=slow){
            p = p.next;
            slow = slow.next;
          }
          return p;
        }
      }
      return null;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
