package com.leetcode.oj;


public class ReverseLinkedListII_92 {

  // Definition for singly-linked list.
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode p = head;
    int length = 0;
    while(p!=null){
      length++;
      p = p.next;
    }
    if(length<n){
      return head;
    }
    final int diff = n-m;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode mprev = dummy;
    ListNode nprev = dummy;
    int d = diff;
    while(d>0){
      nprev = nprev.next;
      d--;
    }
    while(m>1){
      mprev = mprev.next;
      nprev = nprev.next;
      m--;
    }
    ListNode np = nprev.next;
    ListNode npost = np.next;
    ListNode reverseHead = npost;
    p = mprev.next;
   while(p!=null&&p!=npost){
     ListNode tmpListNode = p.next;
     p.next = reverseHead;
     reverseHead = p;
     p = tmpListNode;
   }
   mprev.next = reverseHead;
   return dummy.next;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    new ReverseLinkedListII_92().reverseBetween(head, 1, 2);
  }

}
