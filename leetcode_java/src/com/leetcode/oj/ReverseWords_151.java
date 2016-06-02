package com.leetcode.oj;

public class ReverseWords_151 {

  public String reverseWords2(String s){
    if(s==null){
      return null;
    }
    if(s.equals("")){
      return "";
    }
    StringBuilder sb = new StringBuilder(s);
    sb.reverse();
    int wi = 0;
    int wj = 0;
    while(wi<=wj&&wj<sb.length()){
      while(wi<sb.length()&&Character.isWhitespace(sb.charAt(wi))){
        sb.deleteCharAt(wi);
       
      }
      sb.insert(wi, ' ');
      wi++;
      wj=wi+1;
      while(wj<sb.length()&&!Character.isWhitespace(sb.charAt(wj))){
        wj++;
      }
      int i=wi;
      int j=wj-1;
      while(i<j&&j<sb.length()){
        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);
        i++;
        j--;
      }
      wi=wj;
    }
    
    return sb.toString().trim();
  }
  public String reverseWords(String s){
    if(s==null){
      return null;
    }
    if(s.equals("")){
      return "";
    }
    String[] strs = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for(int i=strs.length-1;i>=0;i--){
      if(strs[i].isEmpty()){
        continue;
      }
      sb.append(new StringBuilder(strs[i]).append(" "));
    }
    return sb.toString().trim();
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String string = "hi!";
    System.out.println("H"+new ReverseWords_151().reverseWords2(string)+"H");
//    String[] strs=string.split(" ");   
//    for(int i=0;i<strs.length;i++){
//      System.out.print(strs[i]);
//    }
  }

}
