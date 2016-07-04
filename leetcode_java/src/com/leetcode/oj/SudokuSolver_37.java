package com.leetcode.oj;

// 37 https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver_37 {
  private boolean hasSolution;

  public void solveSudoku(char[][] board) {
    int N = board.length;
    if (N != 9) {
      return;
    }
    hasSolution = false;
    int[] rowsBitMark = new int[N];
    int[] colsBitMark = new int[N];
    int[] rectBitMakr = new int[N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        mark(i, j, board[i][j] - '0', rowsBitMark, colsBitMark, rectBitMakr);
      }
    }
    dfs(board, 0, rowsBitMark, colsBitMark, rectBitMakr);
  }

  private void dfs(char[][] board, int k, int[] rowsBitMark, int[] colsBitMark, int[] rectBitMakr) {
    if (k == 81 || hasSolution) {
      hasSolution = true;
      return;
    }
    int row = k / 9;
    int col = k % 9;
    if (board[row][col] != '.') {
      dfs(board, k + 1, rowsBitMark, colsBitMark, rectBitMakr);
      return;
    }
    for (int i = 1; i <= 9; i++) {
      if (isValid(row, col, i, rowsBitMark, colsBitMark, rectBitMakr)) {
        mark(row, col, i, rowsBitMark, colsBitMark, rectBitMakr);
        board[row][col] = (char) ('0' + i);
        dfs(board, k + 1, rowsBitMark, colsBitMark, rectBitMakr);
        if (!hasSolution) {
          board[row][col] = '.';
          unmark(row, col, i, rowsBitMark, colsBitMark, rectBitMakr);
        }
      }
    }
  }

  private void mark(int i, int j, int v, int[] rows, int[] cols, int[] rect) {
    int mark = 1 << v;
    rows[i] |= mark;
    cols[j] |= mark;
    rect[(i / 3) * 3 + j / 3] |= mark;
  }

  private void unmark(int i, int j, int v, int[] rows, int[] cols, int[] rect) {
    int mark = ~(1 << v);
    rows[i] &= mark;
    cols[j] &= mark;
    rect[(i / 3) * 3 + j / 3] &= mark;
  }

  private boolean isValid(int i, int j, int v, int[] rows, int[] cols, int[] rect) {
    int mark = 1 << v;
    return (rows[i] & mark) == 0 && (cols[j] & mark) == 0
        && (rect[(i / 3) * 3 + j / 3] & mark) == 0;
  }
}
