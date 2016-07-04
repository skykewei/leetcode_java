package com.leetcode.oj;

public class LongestPalindrome_5 {

  public String longestPalindrome2(String s){
    if(s==null){
      return null;
    }
    s = s.trim();
    int len=s.length();
    if(len==0){
      return "";
    }
    int n=len;

    while(n>=1){
      for(int i=0;i<=len-n;i++){
        String tmp = s.substring(i, i+n);
        boolean is=true;
        int ii=0,jj=tmp.length()-1;
        while(ii<jj){
          if(tmp.charAt(ii)!=tmp.charAt(jj)){
            is=false;
            break;
          }
           ii++;
           jj--;
        }
        if(is){
          return tmp;
        }
      }
      n--;
    }
    return null;
  }
  public String longestPalindrome(String s){
    if(s==null){
      return null;
    }
    
    return null;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(new LongestPalindrome_5().longestPalindrome("a"));
  }

}
