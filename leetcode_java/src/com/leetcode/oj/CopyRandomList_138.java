package com.leetcode.oj;

import java.util.Arrays;
import java.util.HashMap;

public class CopyRandomList_138 {

  class RandomListNode{
    int label;
    RandomListNode next,random;
    public RandomListNode(int x) {
      this.label = x;
    }
  }
  public RandomListNode copyRandomList(RandomListNode head){
    RandomListNode ret = new RandomListNode(-1);
    RandomListNode current = ret;
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    while(head!=null){
      current.next = new RandomListNode(head.label);
      current.next.random = head.random;
      current = current.next;
      map.put(head, current);
      head = head.next;
    }
    current = ret.next;
    while(current!=null){
      RandomListNode tmp = map.get(current.random);
      current.random = tmp;
      current = current.next;
    }
    return ret.next;
  }
  public int singleNumber(int[] nums){
    int[] count = new int[32];
    Arrays.fill(count, 0);
    int ret = 0;
    for(int i=0;i<count.length;i++){
      for(int j=0;j<nums.length;j++){
        if(((nums[j]>>i) & 1 )!=0){
          count[i]++;
        }
      }
      if(count[i]%3!=0){
        ret |= 1<<i;
      }
    }
    return ret;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
