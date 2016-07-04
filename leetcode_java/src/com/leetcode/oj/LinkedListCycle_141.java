package com.leetcode.oj;


public class LinkedListCycle_141 {

  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
  
  public boolean hasCycle(ListNode head) {
     ListNode p = head;
     ListNode q = head;
     while(q!=null&&q.next!=null){
       p = p.next;
       q = q.next.next;
       if(p==q){
         return true;
       }
     }
     return false;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
