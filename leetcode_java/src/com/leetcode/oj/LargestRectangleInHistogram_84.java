package com.leetcode.oj;

import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram_84 {

  public int largestRectangleArea(int[] heights) {
    int size = 0;
    Stack<Integer> stk = new Stack<>();
    for(int i=0;i<heights.length;) {
      if(stk.isEmpty()||heights[i]>heights[stk.peek()]){
        stk.push(i);
        i++;
      }else {
        int tmp = stk.pop();
        int w = 0;
        if(stk.isEmpty()){
          w = i;
        }else{
          w = i-stk.peek()-1;
        }
        int s = heights[tmp]*w;
        if(s>size){
          size = s;
        }
      }
    }
    while(!stk.isEmpty()){
      int tmp = stk.pop();
      int w = 0;
      if(stk.isEmpty()){
        w = heights.length;
      }else{
        w = heights.length-stk.peek()-1;
      }
      int s = heights[tmp]*w;
      if(s>size){
        size = s;
      }  
    }
    return size;
  }
}
