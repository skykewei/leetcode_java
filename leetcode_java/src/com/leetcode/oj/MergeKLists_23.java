package com.leetcode.oj;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class MergeKLists_23 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeKLists2(ListNode[] lists) {
    if (lists == null) {
      return null;
    }

    ListNode head = new ListNode(-1);

    ListNode current = head;
    boolean hasMore = true;
    while (hasMore) {
      hasMore = false;
      int minIndex = -1;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          hasMore = true;
          if (minIndex == -1) {
            minIndex = i;
          } else {
            if (lists[i].val < lists[minIndex].val) {
              minIndex = i;
            }
          }
        }
      }
      if (minIndex != -1) {
        current.next = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        current = current.next;
      }
    }
    return head.next;
  }

  public ListNode mergeKLists3(ListNode[] lists) {
    if (lists == null) {
      return null;
    }
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    ListNode head = new ListNode(-1);

    ListNode current = head;
    boolean hasMore = true;
    while (hasMore) {
      hasMore = false;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          hasMore = true;
          treeMap.put(lists[i].val, i);
        }
      }
      if (!treeMap.isEmpty()) {
        int minValue = treeMap.firstKey();
        int minIndex = treeMap.get(minValue);
        current.next = lists[minIndex];
        current = current.next;
        lists[minIndex] = lists[minIndex].next;
        treeMap.remove(minValue);
      }
    }
    return head.next;
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if(lists==null){
      return null;
    }
    ListNode head = new ListNode(-1);
    ListNode current = head;
    PriorityQueue<ListNode> queue = new PriorityQueue<>(comp);
    for(ListNode node:lists){
      if (node!=null) {
        queue.add(node);
      }
    }
    while(!queue.isEmpty()){
      current.next=queue.poll();
      current = current.next;
      if(current.next!=null){
      queue.add(current.next);
      }
    }
    return head.next;
  }
  private static final Comparator<ListNode> comp = new Comparator<ListNode>(){

    @Override
    public int compare(ListNode o1, ListNode o2) {
      // TODO Auto-generated method stub
      return o1.val-o2.val;
    }};
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(new MergeKLists_23().mergeKLists(null));
  }

}
