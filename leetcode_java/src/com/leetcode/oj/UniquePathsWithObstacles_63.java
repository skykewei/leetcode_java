package com.leetcode.oj;

public class UniquePathsWithObstacles_63 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid){
    if(obstacleGrid==null){ 
      return -1;
    }
    int r = obstacleGrid.length;
    if(r==0){
      return -1;
    }
    int c = obstacleGrid[0].length;
    if(c==0){
      return -1;
    }
    int[][] cnt = new int[r+1][c+1];
    cnt[r][c-1] = 1;
    for(int i=r-1;i>=0;i--){
      for(int j=c-1;j>=0;j--){
        if(obstacleGrid[i][j]==1){
          cnt[i][j] = 0;
        }else{
          cnt[i][j] = cnt[i+1][j]+cnt[i][j+1];
        }
      }
    }
    return cnt[0][0];
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] a=new int[0];
    int[] b = null;
    System.out.println(a.length);
  }

}
