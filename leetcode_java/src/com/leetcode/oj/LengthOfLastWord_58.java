package com.leetcode.oj;
// 58 https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord_58 {

  public int lengthOfLastWord(String s) {
     if(s==null||s.length()==0){
       return 0;
     }
     s = s.trim();
     int len = 0;
     for(int i=s.length()-1;i>=0;i--){
       if(s.charAt(i)!=' '){
         len++;
       }else{
         return len;
       }
     }
     return len;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
