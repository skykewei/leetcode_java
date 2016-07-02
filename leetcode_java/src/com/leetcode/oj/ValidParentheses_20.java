package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
// 20 https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses_20 {

  private static final Map<Character, Character> mp = new HashMap<Character, Character>() {
    {
      put('(', ')');
      put('{', '}');
      put('[', ']');
    }
  };

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    if(s==null){
      return false;
    }
    for(char c:s.toCharArray()){
      if(mp.containsKey(c)){
        stack.push(c);
      }else if(stack.isEmpty()||mp.get(stack.pop())!=c){
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
