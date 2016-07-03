package com.leetcode.oj;
//74 https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix_74 {
  //O(m+n)
  public boolean searchMatrix_0(int[][] matrix, int target) {
    int m = matrix.length;
    if(m==0){
      return false;
    }
    int n=matrix[0].length;
    int i=0,j=n-1;
    while(i<m&&j>=0){
      if(matrix[i][j]==target){
        return true;
      }
      if(target>matrix[i][j]){
        i++;
      }else {
        j--;
      }
    }
    return false;
  }
  //O(log(m*n))
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if(m==0){
      return false;
    }
    int n=matrix[0].length;
    int first=0;
    int last=m*n;
    while(first<last){
      int mid=(first+last)>>1;
      int val = matrix[mid/n][mid%n];
      if(target==val){
        return true;
      }
      if(target>val){
        first=mid+1;
      }else {
        last=mid;
      }
    }
    return false;
  }
}
