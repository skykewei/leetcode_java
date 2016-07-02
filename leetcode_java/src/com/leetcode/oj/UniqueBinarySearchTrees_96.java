package com.leetcode.oj;
// 96 https://leetcode.com/problems/unique-binary-search-trees/
public class UniqueBinarySearchTrees_96 {

  public int numTrees(int n) {
     if(n<0){
       return -1;
     }
     int[] log = new int[n+1];
     log[0]=1;
     for(int i=1;i<=n;i++){
       int sum= 0;
       for(int j=1;j<=i;j++){
         sum+= log[j-1]*log[i-j];
       }
       log[i]=sum;
     }
     return log[n];
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
