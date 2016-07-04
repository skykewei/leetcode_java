package com.leetcode.oj;
// 10 https://leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching_10 {

  public boolean isMatch(String s, String p) {
    return isMatch(s,0, p,0);
  }
  public boolean isMatch(String s,int i,String p, int j){
    if(j==p.length()){
      return i==s.length();
    }
    if(j==p.length()-1){
      return i==(s.length()-1)&&(p.charAt(j)=='.'||p.charAt(j)==s.charAt(i));
    }
    if(p.charAt(j+1)!='*'){
      if(i<s.length()&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.')){
        return isMatch(s,i+1, p,j+1);
      }else {
        return false;
      }
    }else{
      while(i<s.length()&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.')){
        if(isMatch(s,i, p,j+2)){
          return true;
        }
        i++;
      }
      return isMatch(s,i, p,j+2);
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
