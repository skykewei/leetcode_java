package com.leetcode.oj;

import java.util.ArrayDeque;

// 71 https://leetcode.com/problems/simplify-path/
public class SimplifyPath_71 {

  public String simplifyPath(String path) {
    if (path == null) {
      return null;
    }
    String[] sa = path.split("/");
    ArrayDeque<String> aq = new ArrayDeque<String>();
    for (String s : sa) {
      if(s.equals("")||s.equals(".")){
        continue;
      }
      if (s.equals("..")) {
        aq.pollLast();
      } else {
        aq.add(s);
      }
    }
   
    if(aq.isEmpty()){
      return "/";
    }
    String ret = "";
    while(!aq.isEmpty()){
      ret += "/"+aq.pollFirst();
    }
    return ret;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(new SimplifyPath_71().simplifyPath("/."));
  }

}
