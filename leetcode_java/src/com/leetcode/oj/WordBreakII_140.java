package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.SliderUI;

// 140 https://leetcode.com/problems/word-break-ii/
public class WordBreakII_140 {

  public List<String> wordBreak(String s, Set<String> wordDict) {
    // List<String> ret = new ArrayList<String>();
    Object[] ret = new Object[s.length() + 1];
    boolean[] f = new boolean[s.length() + 1];
    f[0] = true;
    ret[0] = new ArrayList<String>();
    ((ArrayList<String>)ret[0]).add("");
    for (int i = 1; i <= s.length(); i++) {
      for (int j = i - 1; j >= 0; j--) {
        String tmp = s.substring(j, i);
        if (f[j] && wordDict.contains(tmp)) {
          f[i] = true;
          if (ret[i] == null) {
            ret[i] = new ArrayList<String>();
          }
          ArrayList<String> tList = (ArrayList<String>) ret[i];
          for (String st : (ArrayList<String>) ret[j]) {
            tList.add((st+" "+tmp).trim());
          }
        }
      }
    }
    if(f[s.length()]==false){
      return new ArrayList<>();
    }
    
    List<String> reList = (ArrayList<String>) ret[s.length()];
    return reList;
  }

  public static void main(String[] args) {
    String string = "";
    string = string + "hhehe";
    System.out.println(string);
  }

}
