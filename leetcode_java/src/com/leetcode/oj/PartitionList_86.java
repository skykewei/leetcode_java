package com.leetcode.oj;
//86 https://leetcode.com/problems/partition-list/
public class PartitionList_86 {


  // Definition for singly-linked list.
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
  public ListNode partition(ListNode head, int x) {
     
      ListNode cur = head;
      ListNode lessDummy=new ListNode(-1);
      ListNode lessp = lessDummy;
      ListNode greaterDummy=new ListNode(-1);
      ListNode greaterp = greaterDummy;
      while(cur!=null){
        if(cur.val<x){
          lessp.next = cur;
          lessp = lessp.next;
          cur = cur.next;
          
        }else {
          greaterp.next = cur;
          greaterp = greaterp.next;
          cur = cur.next;
       
        }
      }
      lessp.next = greaterDummy.next;
      greaterp.next = null;
      return lessDummy.next;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListNode head = new ListNode(2);
    head.next = new ListNode(1);
    new PartitionList_86().partition(head, 2);
  }

}
