package com.leetcode.oj;

public class SetMatrixZeroes_73 {

  public void setZeroes(int[][] matrix){
    if(matrix==null||matrix.length==0){
      return;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    boolean firstRowZero = false;
    boolean firstColZero = false;
    for(int i=0;i<col;i++){
      if(matrix[0][i]==0){
        firstRowZero = true;
      }
    }
    for(int i=0;i<row;i++){
      if(matrix[i][0]==0){
        firstColZero = true;
      }
    }
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        if(matrix[i][j]==0){
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    // row
    for(int i=1;i<row;i++){
      if(matrix[i][0]==0){
        for(int j=0;j<col;j++){
          matrix[i][j] = 0;
        }
      }
    }
    // col
    for(int i=1;i<col;i++){
      if(matrix[0][i]==0){
        for(int j=0;j<row;j++){
          matrix[j][i] = 0;
        }
      }
    }
    if(firstColZero){
      for(int i=0;i<row;i++){
        matrix[i][0] = 0;
      }
    }
    if(firstRowZero){
      for(int i=0;i<col;i++){
        matrix[0][i] = 0;
      }
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
