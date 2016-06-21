package com.leetcode.oj;
// 72 https://leetcode.com/problems/edit-distance/

import javax.print.attribute.standard.RequestingUserName;

public class EditDistance_72 {
  public int minDistance(String word1, String word2) {
   int w1 = word1.length();
   int w2 = word2.length();
   int[][] f=new int[w1+1][w2+1];
   for(int i=0;i<=w1;i++){
     f[i][0] = i;
   }
   for(int i=0;i<=w2;i++){
     f[0][i] = i;
   }
   for(int i=1;i<=w1;i++){
     for(int j=1;j<=w2;j++){
       if(word1.charAt(i-1)==word2.charAt(j-1)){
         f[i][j] = f[i-1][j-1];
       }else {
         f[i][j]= 1+Math.min(Math.min(f[i-1][j-1],f[i][j-1]),f[i-1][j]);
       }
     }
   }
   return f[w1][w2];
  }
 
}
