package com.leetcode.oj;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

// 17 https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfAPhoneNumber_17 {
  private static final String[] M={
      "_",//0
      "@",//1
      "abc",//2
      "def",//3
      "ghi",//4
      "jkl",//5
      "mno",//6
      "pqrs",//7
      "tuv",//8
      "wxyz"//9
  };
  public List<String> letterCombinations(String digits) {
    List<String> retList = new ArrayList<>();
    if(digits==null||digits.length()==0){
      return retList;
    }
    StringBuilder path = new StringBuilder();
    dfs(digits,0,path,retList);
    return retList;
  }
  private void dfs(String digits,int from,StringBuilder path,List<String> retList){
    if(from==digits.length()){
      retList.add(path.toString());
      return;
    }
    int d = digits.charAt(from)-'0';
    for(int i=0;i<M[d].length();i++){
      path.append(M[d].charAt(i));
      dfs(digits, from+1, path, retList);
      path.deleteCharAt(path.length()-1);
    }
  }
}
