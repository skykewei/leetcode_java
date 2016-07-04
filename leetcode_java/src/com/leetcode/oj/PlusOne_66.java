package com.leetcode.oj;
//66 https://leetcode.com/problems/plus-one/
public class PlusOne_66 {

  public int[] plusOne(int[] digit){
    int i=digit.length-1;
    int con = 1;
    while(i>=0&&con>0){
      int tmp = digit[i]+con;
      digit[i]=tmp%10;
      con = tmp/10;
      i--;
    }
    if(con==0){
      return digit; 
    }
    int[] ret = new int[digit.length+1];
    ret[0]=1;
    for(i=1;i<ret.length;i++){
      ret[i] = digit[i-1];
    }
    return ret;
  }
  
  public boolean isPalindrome(int x){
    if(x<0){
        return false;
    }
    int dc = 0;
    int t = x;
    while(t!=0){
      dc++;
      t /=10;
    }
    if(dc==0||dc==1){
      return true;
    }
    int right = x%10;
    int left = x/(int)Math.pow(10, dc-1);
    while(right==left){
     
      x/=10;
      dc--;
      right = x%10;  
      
      if(dc==1||dc==0){
        return true;
      }
      left = x/(int)Math.pow(10, dc-1); 
      x %= (int)Math.pow(10, dc-1);
      dc--;
    }
    return false;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int digit = -121;
    System.out.println(new PlusOne_66().isPalindrome(121));
  }

}
