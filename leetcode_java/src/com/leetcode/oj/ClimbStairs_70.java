package com.leetcode.oj;

import java.lang.invoke.VolatileCallSite;

public class ClimbStairs_70 {
  volatile boolean ok = true;
  
  public int climbStairs(int n){
    if(n<=0){
      return 0;
    }
    int f1= 1;
    int f2=1;
    int tmp = 0;
    for(int i=2;i<=n;i++){
      tmp = f1+f2;
      f1=f2;
      f2=tmp;
    }
   
    return f2;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int n = new ClimbStairs_70().climbStairs(44);
    System.out.println("n="+n);
  }

}
