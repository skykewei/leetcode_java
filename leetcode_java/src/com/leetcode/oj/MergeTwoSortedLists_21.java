package com.leetcode.oj;
// 21 https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists_21 {

  public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
  }
  public ListNode mergeTwoLists(ListNode l1,ListNode l2){
    if(l1==null){
      return l2;
    }
    if(l2==null){
      return l1;
    }
    ListNode retH = null;
    ListNode retT = null;
    ListNode p1 = l1;
    ListNode p2 = l2;
    while(p1!=null&&p2!=null){
      if(p1.val<p2.val){
        if(retT==null){
          retH = p1;
          retT = p1;
        }else {
          retT.next = p1;
          retT = retT.next;
        } 
        p1 = p1.next;
      }else {
        if(retT==null){
          retH = p2;
          retT = p2;
        }else {
          retT.next = p2;
          retT = retT.next;
        }
        p2 = p2.next;
      }
    }
    if(p1!=null){
      retT.next = p1;
    }
    if(p2!=null){
      retT.next = p2;
    }
    return retH;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
