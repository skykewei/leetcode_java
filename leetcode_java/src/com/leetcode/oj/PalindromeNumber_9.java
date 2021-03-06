package com.leetcode.oj;
// 9 https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber_9 {

  public boolean isPalindrome(int x){
    if(x<0){
      return false;
    }
    int div = 1;
    while(x/div>=10){
      div *= 10;
    }
    while(x!=0){
      int left = x/div;
      int right = x%10;
      if(left!=right){
        return false;
      }
      x %= div;
      x /= 10;
      div /= 100;
    }
    return true;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
