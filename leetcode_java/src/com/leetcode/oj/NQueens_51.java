package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

// 51 https://leetcode.com/problems/n-queens/
public class NQueens_51 {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<List<String>>();
    if(n==0){
      return result;
    }
    boolean[] cols = new boolean[n];
    boolean[] diagonal = new boolean[(n<<1)-1];
    boolean[] backDiagonal=new boolean[(n<<1)-1];
    boolean[][] board = new boolean[n][n];
    dfs(n, 0, cols,diagonal,backDiagonal, board, result);
    return result;
  }
  private void dfs(int n,int step,boolean[]cols,boolean[]diagonal,boolean[]backDiagonal ,boolean[][]board,List<List<String>> result){
    if(step==n){
      result.add(genSolution(board));
      return;
    }
    for(int i=0;i<n;i++){
      if(cols[i]==false&&diagonal[step-i+n-1]==false&&backDiagonal[step+i]==false){
        cols[i]=true;
        diagonal[step-i+n-1]=true;
        backDiagonal[step+i]=true;
        board[step][i]=true;
        dfs(n, step+1, cols,diagonal,backDiagonal, board,result);
        board[step][i]=false;
        cols[i]=false;
        diagonal[step-i+n-1]=false;
        backDiagonal[step+i]=false;
      }
    }
  }
  private ArrayList<String> genSolution(boolean[][]board){
    StringBuilder sb = new StringBuilder();
    ArrayList<String> solution = new ArrayList<String>();
    for(int i=0;i<board.length;i++){
      sb.delete(0, sb.length());
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]){
          sb.append('Q');
        }else{
          sb.append('.');
        }
      }
      solution.add(sb.toString());
    }
    return solution;
  }
}
