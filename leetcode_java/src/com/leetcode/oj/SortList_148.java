package com.leetcode.oj;

// 148 https://leetcode.com/problems/sort-list/
public class SortList_148 {


  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode sortList(ListNode head) {
    if(head==null||head.next==null){
      return head;
    }
    ListNode fast=head;
    ListNode slow=head;
    while(fast.next!=null&&fast.next.next!=null){
      fast = fast.next.next;
      slow = slow.next;
    }
    fast = slow;
    slow = slow.next;
    fast.next = null;
    ListNode lt1 = sortList(head);
    ListNode lt2 = sortList(slow);
    return mergeTwoLists(lt1, lt2);
  }
  private ListNode mergeTwoLists(ListNode lt1,ListNode lt2){
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while(lt1!=null&&lt2!=null){
      if(lt1.val<lt2.val){
        prev.next = lt1;
        prev = prev.next;
        lt1 = lt1.next;
      }else{
        prev.next = lt2;
        prev = prev.next;
        lt2 = lt2.next;
      }
    }
    while(lt1!=null){
      prev.next = lt1;
      prev = prev.next;
      lt1 = lt1.next;
    }
    while(lt2!=null){
      prev.next = lt2;
      prev = prev.next;
      lt2 = lt2.next;
    }
    return dummy.next;
  }
}
