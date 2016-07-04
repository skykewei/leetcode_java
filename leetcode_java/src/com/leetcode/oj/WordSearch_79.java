package com.leetcode.oj;

//79 https://leetcode.com/problems/word-search/
public class WordSearch_79 {
  private static char TRAVEL = '.';
  private boolean isExist;
  public boolean exist(char[][] board, String word) {
    if(board==null){
      return false;
    }
    int M = board.length;
    if(M==0){
      return false;
    }
    int N = board[0].length;
    if(word==null){
      return false;
    }
    if(word.length()==0){
      return true;
    }
    if(M*N<word.length()){
      return false;
    }
    isExist = false;
    for(int i=0;!isExist&&i<M;i++){
      for(int j=0;!isExist&&j<N;j++){
        dfs(board,i,j,word,0);
      }
    }
    return isExist;
  }
  private void dfs(char[][] board,int si,int sj, String word,int k){
    if(k==word.length()||isExist){
      isExist = true;
      return;
    }
    char ch = board[si][sj];
    if(word.charAt(k)!=ch){
      return;
    }
    k++;
    if(k==word.length()){
      isExist=true;
      return;
    }
    if(!isExist&&isValid(board, si+1, sj)){
      board[si][sj] = TRAVEL;
      dfs(board, si+1, sj, word, k);
      board[si][sj] = ch;
    }
    if(!isExist&&isValid(board, si-1, sj)){
      board[si][sj] = TRAVEL;
      dfs(board, si-1, sj, word, k);
      board[si][sj] = ch;
    }
    if(!isExist&&isValid(board, si, sj+1)){
      board[si][sj] = TRAVEL;
      dfs(board, si, sj+1, word, k);
      board[si][sj] = ch;
    }
    if(!isExist&&isValid(board, si, sj-1)){
      board[si][sj] = TRAVEL;
      dfs(board, si, sj-1, word, k);
      board[si][sj] = ch;
    }
  }
  private boolean isValid(char[][] board,int i,int j){
    int M = board.length;
    int N = board[0].length;
    return i>=0&&i<M&&j>=0&&j<N;
  }
  public static void main(String[]argv){
    char[][] board={{'a'}};
    String word = "a";
    new WordSearch_79().exist(board, word);
  }
}
