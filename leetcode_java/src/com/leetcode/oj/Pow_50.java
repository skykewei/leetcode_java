package com.leetcode.oj;
//50 https://leetcode.com/problems/powx-n/
public class Pow_50 {
  public double myPow(double x, int n) {
    long n2 = n;
    int sign = 1;
    if(n2<0){
      sign=-1;
      n2=-n2;
    }
    if(n2==0){
      return 1;
    }
    double result = 1;
    double p = x;
    while(n2>0){
      if((n2&1)==1){
        result *=p;
      }
      p*=p;
      n2>>=1;
    }
    if(sign==-1){
      result = 1/result;
    }
    return result;
  }
}
