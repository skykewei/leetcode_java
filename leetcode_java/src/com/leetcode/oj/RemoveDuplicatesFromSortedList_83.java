package com.leetcode.oj;

//83 https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedList_83 {


  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode deleteDuplicates(ListNode head) {
    if(head==null){
      return null;
    }
    ListNode prev = head;
    ListNode cur = prev.next;
    while(cur!=null){
      if(cur.val==prev.val){
        cur = cur.next;
      }else{
        prev.next = cur;
        prev = prev.next;
        cur = cur.next;
      }
    }
    prev.next = null;
    return head;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
