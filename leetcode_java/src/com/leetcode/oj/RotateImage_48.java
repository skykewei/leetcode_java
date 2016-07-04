package com.leetcode.oj;

public class RotateImage_48 {

  public void rotate(int[][] matrix) {
   if(matrix==null||matrix.length==0||matrix.length==1){ 
     return;
   }
   int r = matrix.length-2;
   int c = matrix.length-2;
   for(int i=0;i<=r;i++){
     for(int j=0;j<=c;j++){
       int tmp = matrix[i][j];
       matrix[i][j] = matrix[matrix.length-1-j][matrix.length-1-i];
       matrix[matrix.length-1-j][matrix.length-1-i] = tmp;
     }
     c--;
   }
   r = (matrix.length>>1)-1;
   for(int i=0;i<=r;i++){
     for(int j=0;j<matrix.length;j++){
       int tmp = matrix[i][j];
       matrix[i][j] = matrix[matrix.length-1-i][j];
       matrix[matrix.length-1-i][j] = tmp;
     }
   }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
