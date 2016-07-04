package com.leetcode.oj;
//60 https://leetcode.com/problems/permutation-sequence/
public class PermutationSequence_60 {

  public String getPermutation(int n,int k){
    String seq="";
    for(int i=1;i<=n;i++){
      seq += i;
    }
    String ret = "";
    int base = 1;
    for(int i=1;i<=n-1;i++){
      base *= i;
    }
    k--;
    for(int i=n-1;i>0;k%=base,base/=i,i--){
      int j=k/base;
      ret += seq.charAt(j);
      seq = seq.substring(0, j)+seq.substring(j+1);
    }
    ret += seq.charAt(0);
    return ret;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
