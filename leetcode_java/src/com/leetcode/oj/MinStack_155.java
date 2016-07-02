package com.leetcode.oj;

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// 155 https://leetcode.com/problems/min-stack/
public class MinStack_155 {

  private Stack<Integer> stk =new Stack<>();
  private Stack<Integer> minStack=new Stack<>();
  /** initialize your data structure here. */
  public MinStack_155() {
      
  }
  
  public void push(int x) {
      stk.push(x);
      if(minStack.isEmpty()||x<=minStack.peek()){
        minStack.push(x);
      }
  }
  
  public void pop() {
      int t = stk.pop();
      if(t==minStack.peek()){
        minStack.pop();
      }
  }
  
  public int top() {
      return stk.peek();
  }
  
  public int getMin() {
      return minStack.peek();
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
