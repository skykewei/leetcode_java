package com.leetcode.oj;


// 91 https://leetcode.com/problems/decode-ways/
public class DecodeWays_91 {

  public int numDecodings(String s){
    if(s==null||s.length()==0||s.charAt(0)=='0'){
      return 0;
    }
    int prev = 0;
    int cur = 1;
    for(int i=1;i<=s.length();i++){
      if(s.charAt(i-1)=='0'){
        cur = 0;
      }
      if(i<2||!(s.charAt(i-2)=='1'||s.charAt(i-2)=='2'&&s.charAt(i-1)>='0'&&s.charAt(i-1)<='6')){
        prev = 0;
      }
      int tmp = prev;
      prev = cur;
      cur += tmp;
    }
    return cur;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
