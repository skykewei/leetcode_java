package com.leetcode.oj;

public class RemoveDuplicatesFromSortedListII_82 {


  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-1);
    ListNode retp = dummy;
    ListNode cur = head;
    while (cur != null) {
      ListNode p = cur.next;
      if (p == null || p.val != cur.val) {
        retp.next = cur;
        retp = retp.next;
        cur = cur.next;
      } else {
        while (p != null && p.val == cur.val) {
          p = p.next;
        }
        cur = p;
      }

    }
    retp.next = null;
    return dummy.next;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
