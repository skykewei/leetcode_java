package com.leetcode.oj;

public class StrStr_28 {

  public int strStr(String haystack,String needle){
    return haystack.indexOf(needle);
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s1 = "abc";
    System.out.println(new StrStr_28().strStr(s1, ""));
  }

}
