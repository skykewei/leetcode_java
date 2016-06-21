package com.leetcode.oj;
//64 https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum_64 {

  public int minPathSum(int[][] grid) {
    if(grid==null||grid.length==0){
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int[] f = new int[n+1];
    for(int i=n-1;i>=0;i--){
      f[i] = f[i+1]+grid[m-1][i];
    }
    for(int i=m-2;i>=0;i--){
      f[n-1] = grid[i][n-1]+f[n-1];
      for(int j=n-2;j>=0;j--){
        f[j] = grid[i][j]+Math.min(f[j], f[j+1]);
      }
    }
    return f[0];
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
