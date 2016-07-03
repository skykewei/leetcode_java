package com.leetcode.oj;
//240 https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchA2DMatrixII_240 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m=matrix.length;
    if(m==0){
      return false;
    }
    int n=matrix[0].length;
    int i=0,j=n-1;
    while(i<m&&j>=0){
      if(target==matrix[i][j]){
        return true;
      }
      if(target>matrix[i][j]){
        i++;
      }else{
        j--;
      }
    }
    return false;
  }
}
