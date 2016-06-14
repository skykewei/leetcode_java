package com.leetcode.oj;

public class ValidNumber_65 {

  public boolean isNumber(String s) {
    boolean isNumber = false;
    s = s.trim();
    int n = s.length();
    int i = 0;
    if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
      i++;
    }
    while (i < n && Character.isDigit(s.charAt(i))) {
      isNumber = true;
      i++;
    }
    if (i < n && s.charAt(i) == '.') {
      i++;
      while (i < n && Character.isDigit(s.charAt(i))) {
        isNumber = true;
        i++;
      }
    }
    if (isNumber && i < n && s.charAt(i) == 'e') {
      i++;
      isNumber = false;
      if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
        i++;
      }
      while (i < n && Character.isDigit(s.charAt(i))) {
        isNumber = true;
        i++;
      }
    }

    return isNumber && i == n;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
