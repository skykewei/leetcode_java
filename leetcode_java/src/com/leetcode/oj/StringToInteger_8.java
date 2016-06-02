package com.leetcode.oj;

import java.lang.invoke.ConstantCallSite;

public class StringToInteger_8 {

  public int myAtoi2(String str){
    final int INT_MAX = 2147483647;
    final int INT_MIN = -2147483648;
    str = str.trim();
    int n = str.length();
    int signed = 1;
    int i = 0;
    if(n==0){
      return 0;
    }
    if(str.charAt(i)=='-'){
      signed = -1;
      i++;
    }else if(str.charAt(i)=='+'){
      i++;
    }
    long ret = 0;
    int base = 10;
    while(i<n&&Character.isDigit(str.charAt(i))){
      ret = ret*base + str.charAt(i)-'0';
      if(signed==1&&ret>INT_MAX){
        return INT_MAX;
      }
      if(signed==-1&&ret>(-(long)(INT_MIN))){
        return INT_MIN;
      }
      i++;
    }
    return (int) (ret*signed);
  }
  public int myAtoi(String str){
    str = str.trim();
    if(str.length()==0){
      return 0;
    }
    int radix  = 10;
    return Integer.parseInt(str,radix);
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(new StringToInteger_8().myAtoi("-1"));
  }

}
