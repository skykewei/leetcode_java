package com.leetcode.oj;

public class ReverseInteger_7 {

  //ignore the INT.MAX or INT.MIN
  public int reverse(int x){
    int result = 0;
    int base = 10;
    while(x!=0){ 
      if(Math.abs(result)>214748364){
        return 0;
      }
      result = result*base + x%base;
      x /= base;    
    }
    return result;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
     //int x= 1534236469;
     int x=-2147483648;
    // int x = 9646324351;
     System.out.println(new ReverseInteger_7().reverse(x));
  }

}
