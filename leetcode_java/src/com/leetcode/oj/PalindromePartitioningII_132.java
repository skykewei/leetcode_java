package com.leetcode.oj;

public class PalindromePartitioningII_132 {

  public int minCut(String s){
    if(s.length()==0){
      return -1;
    }
    int n = s.length();
    int[] mc = new int[n+1];
    for(int i=0;i<n+1;i++){
      mc[i] = n-i-1;
    }
    boolean[][] pp = new boolean[n][n];
    for(int i=n-1;i>=0;i--){
      for(int j=i;j<=n-1;j++){
        if(s.charAt(i)==s.charAt(j)&&(j-i<2||pp[i+1][j-1])){
          pp[i][j]=true;
        }
        if(pp[i][j]&&(mc[i]>mc[j+1]+1)){
          mc[i] = mc[j+1]+1;
        }
      }
    }
    return mc[0];
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s = "aab";
    System.out.println(new PalindromePartitioningII_132().minCut(s));
  }

}
