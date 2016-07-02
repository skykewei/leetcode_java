package com.leetcode.oj;

//147 https://leetcode.com/problems/insertion-sort-list/
public class InsertionSortList_147 {

  
   // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
   
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = head;
    while(cur!=null){
      ListNode prev = dummy;
      while(prev.next!=null&&cur.val>=prev.next.val){
        prev = prev.next;
      }
      ListNode tmp = cur.next;
      cur.next=prev.next;
      prev.next = cur;
      cur = tmp;
    }
    return dummy.next;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
