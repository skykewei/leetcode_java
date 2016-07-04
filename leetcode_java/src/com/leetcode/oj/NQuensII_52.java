package com.leetcode.oj;

// 52 https://leetcode.com/problems/n-queens-ii/
public class NQuensII_52 {

  private int solve;

  public int totalNQueens(int n) {
    solve = 0;
    if (n == 0) {
      return solve;
    }
    boolean[] cols = new boolean[n];
    boolean[] diagonal = new boolean[(n << 1) - 1];
    boolean[] backDiagonal = new boolean[(n << 1) - 1];
    dfs(n, 0, cols, diagonal, backDiagonal);
    return solve;
  }

  private void dfs(int n, int step, boolean[] cols, boolean[] diagonal, boolean[] backDiagonal) {
    if (step == n) {
      solve++;
      return;
    }
    for (int i = 0; i < n; i++) {
      if (cols[i] == false && diagonal[step - i + n - 1] == false
          && backDiagonal[step + i] == false) {
        cols[i] = true;
        diagonal[step - i + n - 1] = true;
        backDiagonal[step + i] = true;
        dfs(n, step + 1, cols, diagonal, backDiagonal);
        cols[i] = false;
        diagonal[step - i + n - 1] = false;
        backDiagonal[step + i] = false;
      }
    }
  }
}
