package com.leetcode.oj;

// 125 https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome_125 {

  public boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        sb.append(ch);
      }
    }
    String s2 = sb.toString();
    String s1 = sb.reverse().toString();
    return s1.equalsIgnoreCase(s2);
  }

  public boolean isPalindrome2(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
        i++;
      while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
        j--;
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    String string = " ";
    System.out.println(new ValidPalindrome_125().isPalindrome(string));
  }
}
