package com.leetcode.oj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_3 {

  public int lengthOfLongestSubstring(String s){
    
    if(s==null){
      return -1;
    }
    s = s.trim();
    if(s.length()==0){
      return 0;
    }
    Map<Character, Integer> exited = new HashMap<>();
    int j=0;
    int len=s.length();
    int mlen = -1;
    int begin = 0;
    for(;j<len;j++){
      char ch = s.charAt(j);
      if(exited.containsKey(ch)){
        int index = exited.get(ch);
        if(index>=begin){
          if(j-begin>mlen){
            mlen = j-begin;
           
          }
          begin = index+1;
        }  
      }
      exited.put(ch, j);
    }
    if(j-begin>mlen){
      mlen=j-begin;
    }
    return mlen;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String string="abcabab";
   
    System.out.println(new LengthOfLongestSubstring_3().lengthOfLongestSubstring(string));
  }

}
