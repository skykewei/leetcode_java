package com.leetcode.oj;

import java.util.Set;

//139 https://leetcode.com/problems/word-break/
public class WordBreak_139 {

  public boolean wordBreak(String s, Set<String> wordDict) {
    boolean[] f = new boolean[s.length()+1];
    f[0] = true;
    for(int i=1;i<=s.length();i++){
      for(int j=i-1;j>=0;j--){
        if(f[j]&&wordDict.contains(s.substring(j,i))){
          f[i] = true;
        }
      }
    }
    return f[s.length()];
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
