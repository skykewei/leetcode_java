package com.leetcode.oj;

public class AddTwoNumbers_2 {

  public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
  }
  public ListNode addTwoNumbers(ListNode l1,ListNode l2){
    ListNode ret = new ListNode(-1);
    ListNode pret = ret;
    int counter = 0;
    while(l1!=null&&l2!=null){
      int tmp = l1.val+l2.val+counter;
      pret.next = new ListNode(tmp%10);
      counter = tmp/10;
      pret = pret.next;
      l1=l1.next;
      l2=l2.next;
    }
    while(l1!=null){
      int tmp = l1.val+counter;
      pret.next = new ListNode(tmp%10);
      counter = tmp/10;
      pret=pret.next;
      l1=l1.next;
    }
    while(l2!=null){
      int tmp = l2.val+counter;
      pret.next = new ListNode(tmp%10);
      counter = tmp/10;
      pret=pret.next;
      l2=l2.next;
    }
    if (counter>0){
      pret.next = new ListNode(counter);
    }
    return ret.next;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
   
  }

}
