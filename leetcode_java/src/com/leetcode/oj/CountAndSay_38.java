package com.leetcode.oj;


// 38 https://leetcode.com/problems/count-and-say/
public class CountAndSay_38 {

  public String countAndSay(int n) {
    if(n==1){
      return "1";
    }
    String ret = "1";
    
    for(int i=1;i<n;i++){
      int len = ret.length();
      StringBuilder sb = new StringBuilder();
      int cnt = 1;
      char prev = ret.charAt(0);
      for(int j=1;j<len;j++){
        if(ret.charAt(j)==prev){
          cnt++;
        }else {
          sb.append(""+cnt+prev);
          cnt = 1;
          prev = ret.charAt(j);
        }
      }
      sb.append(""+cnt+prev);
      ret = sb.toString();
    }
    return ret;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(new CountAndSay_38().countAndSay(10));
  }

}
