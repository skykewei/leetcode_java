package com.leetcode.oj;
// 5 https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring_5 {

  public String longestPalindrome(String s){
    if(s==null){
      return null;
    }
    int len=s.length();
    int start=0;
    int end = -1;
    for(int i=0;i<len;i++){
      int n1 = expandPal(s,i,i);
      int n2 = expandPal(s,i,i+1);
      int nm = Math.max(n1, n2);
      if(nm>end-start+1){
        start = i-(nm-1)/2;
        end = i+nm/2;
      }
    }
    return s.substring(start,end+1);
  }
  private int expandPal(String s,int start,int end){
    int st=start;
    int ed=end;
    int len=s.length();
    while(st>=0&&ed<len&&s.charAt(st)==s.charAt(ed)){
      st--;
      ed++;
    }
    return ed-st-1;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(new LongestPalindromicSubstring_5().longestPalindrome("abcbc"));
  }

}
