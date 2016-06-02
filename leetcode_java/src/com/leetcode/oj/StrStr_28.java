package com.leetcode.oj;

public class StrStr_28 {

  //java call
  public int strStr2(String haystack,String needle){
    return haystack.indexOf(needle);
  }
  
  public int strStr(String haystack,String needle){
    if(needle==null){
      return -1;
    }
    if(needle.equals("")){
      return 0;
    }
    if(haystack==null){
      return -1;
    }
    if(haystack.length()<needle.length()){
      return -1;
    }
    
    int m,i;
    return 0; 
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s1 = "abc";
    System.out.println(new StrStr_28().strStr(s1, ""));
  }

}
